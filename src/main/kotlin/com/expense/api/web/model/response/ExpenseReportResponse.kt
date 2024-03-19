package com.expense.api.web.model.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseReportResponse(

    @get:JsonProperty("gasto_medio_dia")
    val averageSpend: String? = null,

    @get:JsonProperty("maior_gasto_dia")
    val biggerSpend: ExpenseResponse? = null,

    @get:JsonProperty("data_inicial")
    val initialDateTime: String? = null,

    @get:JsonProperty("data_final")
    val endDateTime: String? = null,

    @get:JsonProperty("gastos")
    val expenses: MutableList<ExpenseResponse>? = null
)