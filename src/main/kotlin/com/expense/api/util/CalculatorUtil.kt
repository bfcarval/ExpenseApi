package com.expense.api.util

import com.expense.api.service.dto.ExpenseDTO
import java.math.BigDecimal

class CalculatorUtil {

    companion object {
        fun findAverageSpend(amounts: MutableList<BigDecimal>): BigDecimal =
            amounts.sumOf { it }.div(amounts.size.toBigDecimal())

        fun findBiggerSpend(expenses: MutableList<ExpenseDTO>): ExpenseDTO {
            expenses.sortByDescending { it.amount }
            return expenses.first()
        }
    }
}