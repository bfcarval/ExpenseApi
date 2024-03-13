package com.payment.api.service.mapper

import com.payment.api.database.entity.ExpenseEntity
import com.payment.api.service.dto.ExpenseDTO
import java.math.BigDecimal

fun ExpenseDTO.toEntity() = ExpenseEntity(
    id = id,
    personName = personName,
    description = description,
    amount = amount?: BigDecimal.ZERO,
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
    personName = expenseDTO.personName
    description = expenseDTO.description
    amount = expenseDTO.amount?: BigDecimal.ZERO
    tags = expenseDTO.tags
    createdDate = expenseDTO.createdDate

    return this
}

