package com.expense.api.service.mapper

import com.expense.api.database.entity.ExpenseEntity
import com.expense.api.service.dto.ExpenseDTO
import java.math.BigDecimal

fun ExpenseDTO.toEntity() = ExpenseEntity(
    id = id,
    personName = personName,
    description = description,
    amount = amount ?: BigDecimal.ZERO,
    tags = tags,
    createdDate = createdDate
)

fun ExpenseEntity.toDTO() = ExpenseDTO(
    id = id,
    personName = personName,
    description = description,
    amount = amount,
    tags = tags,
    createdDate = createdDate
)

fun ExpenseEntity.toUpdate(expenseDTO: ExpenseDTO) : ExpenseEntity {
    personName = expenseDTO.personName?: personName
    description = expenseDTO.description?: description
    amount = expenseDTO.amount?: amount
    tags = expenseDTO.tags?: tags
    createdDate = expenseDTO.createdDate?: createdDate

    return this
}

