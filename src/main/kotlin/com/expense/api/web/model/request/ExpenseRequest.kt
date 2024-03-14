package com.expense.api.web.model.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseRequest(

    @get:JsonProperty("nome_da_pessoa")
    val personName: String,

    @get:JsonProperty("descrição")
    val description: String,

    @get:JsonProperty("valor")
    val amount: String,

    val tags: String
)