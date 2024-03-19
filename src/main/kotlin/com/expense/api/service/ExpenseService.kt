package com.expense.api.service

import com.expense.api.database.dao.ExpenseDAO
import com.expense.api.database.entity.ExpenseEntity
import com.expense.api.exception.ExpenseNotFoundException
import com.expense.api.service.dto.ExpenseDTO
import com.expense.api.service.dto.ExpenseReportDTO
import com.expense.api.service.mapper.toDTO
import com.expense.api.service.mapper.toEntity
import com.expense.api.service.mapper.toUpdate
import com.expense.api.util.CalculatorUtil.Companion.findAverageSpend
import com.expense.api.util.CalculatorUtil.Companion.findBiggerSpend
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ExpenseService(private val expenseDAO: ExpenseDAO) {

    fun create(expenseDTO: ExpenseDTO): ExpenseDTO = expenseDAO.create(
        expenseDTO.toEntity()
    ).toDTO()

    fun update(expenseDTO: ExpenseDTO): ExpenseDTO = findById(expenseDTO.id!!).let {
        expenseDAO.update(it.toEntity().toUpdate(expenseDTO)).toDTO()
    }

    fun delete(id: Long) = findById(id).let {
        expenseDAO.delete(id)
    }

    fun findById(id: Long): ExpenseDTO = expenseDAO.findById(id).map {
        it.toDTO()
    }.orElseThrow {
        throw ExpenseNotFoundException("Gasto(s) nao encontrado(s), id=$id")
    }

    fun findAll(): MutableList<ExpenseDTO> = expenseDAO.findAll().let {
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
                averageSpend = findAverageSpend(expenseAmounts),
                biggerSpend = findBiggerSpend(expenseConverted),
                initialDateTime = initialDatetime,
                endDateTime = endDatetime,
                expenses = expenseConverted
            )
        }
    }
}