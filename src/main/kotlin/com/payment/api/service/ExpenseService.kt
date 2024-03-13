package com.payment.api.service

import com.payment.api.database.dao.ExpenseDAO
import com.payment.api.database.entity.ExpenseEntity
import com.payment.api.exception.ExpenseIdInvalidException
import com.payment.api.exception.ExpenseNotFoundException
import com.payment.api.service.dto.ExpenseDTO
import com.payment.api.service.dto.ExpenseReportDTO
import com.payment.api.service.mapper.toDTO
import com.payment.api.service.mapper.toEntity
import com.payment.api.service.mapper.toUpdate
import com.payment.api.util.CalculatorUtil.Companion.calculateAverageExpense
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ExpenseService(private val expenseDAO: ExpenseDAO) {

    fun create(expenseDTO: ExpenseDTO): ExpenseDTO = expenseDAO.create(
        expenseDTO.toEntity()
    ).toDTO()

    fun update(expenseDTO: ExpenseDTO): ExpenseDTO {
        return expenseDTO.id.let {

            findById(expenseDTO.id).let {

                expenseDAO.findById(expenseDTO.id).map {
                    expenseDAO.update(it.toUpdate(expenseDTO)).toDTO()
                }.orElseThrow {
                    ExpenseNotFoundException("Gasto(s) nao encontrado(s), id=${expenseDTO.id}")
                }
            }
        }
    }

    fun delete(id: Long?) {
        expenseDAO.delete(id)
    }

    fun findById(id: Long?): ExpenseDTO {
        return expenseDAO.findById(id).map {
            it.toDTO()
        }.orElseThrow {
            throw ExpenseIdInvalidException("Id invalido para atualizar gastos, id=$id")
        }
    }

    fun findAll(): MutableList<ExpenseDTO> =
        expenseDAO.findAll().let {
            if(it.isEmpty()) throw ExpenseNotFoundException("Gasto(s) nao encontrado(s)")
            it.map(ExpenseEntity::toDTO).toMutableList()
        }

    fun expenseReport(initialDatetime: LocalDateTime, endDatetime: LocalDateTime): ExpenseReportDTO {
        val expenses = expenseDAO.findByDates(initialDatetime, endDatetime)

        return expenses.let {
            if(it.isEmpty()) throw ExpenseNotFoundException(
                """Gasto(s) nao encontrado(s) entre as datas fornecidas,
                    initialDateTime=$initialDatetime, endDatetime=$endDatetime
                    """
            )

            val expenseAmounts = it.map(ExpenseEntity::amount).toMutableList()
            val expenseConverted = it.map(ExpenseEntity::toDTO).toMutableList()

            ExpenseReportDTO(
                averageExpense = calculateAverageExpense(expenseAmounts),
                biggerExpense = findBiggerExpense(expenseConverted),
                initialDateTime = initialDatetime,
                endDateTime = endDatetime,
                expenses = expenseConverted
            )
        }
    }

    private fun findBiggerExpense(expenses: MutableList<ExpenseDTO>): ExpenseDTO {
        expenses.sortByDescending { it.amount }
        return expenses.first()
    }
}