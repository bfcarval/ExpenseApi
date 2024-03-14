package com.expense.api.web.model.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseUpdateRequest(

    @get:JsonProperty("id_gasto")
    val id: String? = null,

    @get:JsonProperty("nome_da_pessoa")
    val personName: String? = null,

    @get:JsonProperty("descrição")
    val description: String? = null,

    @get:JsonProperty("valor")
    val amount: String? = null,

    val tags: String? = null
)