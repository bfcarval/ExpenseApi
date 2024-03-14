package com.expense.api.web.mapper

import com.expense.api.service.dto.ExpenseDTO
import com.expense.api.util.ConverterUtil.Companion.convertBigDecimal
import com.expense.api.web.model.request.ExpenseRequest
import com.expense.api.web.model.response.ExpenseResponse


fun ExpenseDTO.toResponse() = ExpenseResponse(
    id = id.toString(),
    personName = personName.toString(),
    description = description.toString(),
    amount = "R$ ${amount.toString().replace(".",",")}",
    createdDate = createdDate.toString(),
    tags = tags.toString()
)

fun ExpenseRequest.toDTO(id: Long? = null) = ExpenseDTO(
    id = id,
    personName = personName,
    description = description,
    amount = convertBigDecimal(amount),
    tags = tags
)