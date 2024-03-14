package com.expense.api.web.model.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseResponse(

    @get:JsonProperty("id_gasto")
    val id: String? = null,

    @get:JsonProperty("nome_da_pessoa")
    val personName: String? = null,

    @get:JsonProperty("descrição")
    val description: String? = null,

    @get:JsonProperty("data_hora")
    val createdDate: String? = null,

    @get:JsonProperty("valor")
    val amount: String? = null,

    val tags: String? = null
)