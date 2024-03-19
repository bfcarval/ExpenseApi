package com.expense.api.service.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseReportDTO(
    val averageSpend: BigDecimal? = BigDecimal.ZERO,
    val biggerSpend: ExpenseDTO? = null,
    val initialDateTime: LocalDateTime? = null,
    val endDateTime: LocalDateTime? = null,
    val expenses: MutableList<ExpenseDTO>? = null
)