package com.payment.api.util

import java.math.BigDecimal

class CalculatorUtil {

    companion object {
        fun calculateAverageExpense(amounts: MutableList<BigDecimal>): BigDecimal =
            amounts.sumOf { it }.div(amounts.size.toBigDecimal())
    }
}