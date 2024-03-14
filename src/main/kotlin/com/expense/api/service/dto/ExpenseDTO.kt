package com.expense.api.service.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseDTO(
    val id: Long? = null,
    val personName: String? = null,
    val description: String? = null,
    val amount: BigDecimal? = null,
    val tags: String? = null,
    val createdDate: LocalDateTime? = null,
)