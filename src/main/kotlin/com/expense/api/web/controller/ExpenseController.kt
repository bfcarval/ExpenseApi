package com.expense.api.web.controller


import com.expense.api.service.ExpenseService
import com.expense.api.service.dto.ExpenseDTO
import com.expense.api.web.mapper.toDTO
import com.expense.api.web.mapper.toResponse
import com.expense.api.web.model.request.ExpenseRequest
import com.expense.api.web.model.response.ExpenseReportResponse
import com.expense.api.web.model.response.ExpenseResponse
import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/expenses")
@Tag(name = "Expense", description = "Expense Manager")
@Api(description = "API Expense Manager", tags = [("Expense API - Gerenciar Gastos")])
class ExpenseController(private val expenseService: ExpenseService) {

    @PostMapping("/create")
    @Operation(summary = "Create Expense")
    fun create(@RequestBody expenseRequest: ExpenseRequest): ResponseEntity<ExpenseResponse> {
        return ResponseEntity(expenseService.create(expenseRequest.toDTO()).toResponse(), HttpStatus.CREATED)
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Expense")
    fun update(@PathVariable("id") id: Long, @RequestBody expenseRequest: ExpenseRequest): ResponseEntity<ExpenseResponse> {
        return ResponseEntity(expenseService.update(expenseRequest.toDTO(id)).toResponse(), HttpStatus.CREATED)
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Expense")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<String> {
        expenseService.delete(id)

        return ResponseEntity("Delete realizdo com sucesso, id=$id", HttpStatus.OK)
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Find Expense By Id")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<ExpenseResponse> {
        return ResponseEntity(expenseService.findById(id).toResponse(), HttpStatus.OK)
    }

    @GetMapping("/find")
    @Operation(summary = "Find All Expense")
    fun findAll(): ResponseEntity<MutableList<ExpenseResponse>> {
        return ResponseEntity(expenseService.findAll().map(ExpenseDTO::toResponse).toMutableList(), HttpStatus.OK)
    }

    @GetMapping("/report")
    @Operation(summary = "Generate Report Expense")
    fun report(
        @RequestParam("data_inicial", required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") initialDateTime: LocalDateTime,
        @RequestParam("data_final", required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") endDateTime: LocalDateTime
    ): ResponseEntity<ExpenseReportResponse> {
        return ResponseEntity(expenseService.expenseReport(initialDateTime,endDateTime).toResponse(), HttpStatus.OK)
    }
}