package com.expense.api.web.mapper

import com.expense.api.service.dto.ExpenseReportDTO
import com.expense.api.web.model.response.ExpenseReportResponse


fun ExpenseReportDTO.toResponse() = ExpenseReportResponse(
    biggerSpend = biggerSpend?.toResponse(),
    averageSpend = "R$ ${averageSpend.toString().replace(".",",")}",
    endDateTime = endDateTime.toString(),
    initialDateTime = initialDateTime.toString(),
    expenses = expenses?.map { it.toResponse()}?.toMutableList() ?: mutableListOf(),
)