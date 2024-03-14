package com.expense.api.service.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseReportDTO(
    val averageExpense: BigDecimal? = BigDecimal.ZERO,
    val biggerExpense: ExpenseDTO? = null,
    val initialDateTime: LocalDateTime? = null,
    val endDateTime: LocalDateTime? = null,
    val expenses: MutableList<ExpenseDTO>? = null
)