package com.expense.api.util

import java.math.BigDecimal

class ConverterUtil {

    companion object {

        fun convertBigDecimal(value: String?): BigDecimal =
            try {
                value?.let { BigDecimal(value).toDouble().toBigDecimal() }?: BigDecimal.ZERO
            } catch (_: Exception) {
                BigDecimal.ZERO
            }
    }
}