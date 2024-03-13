package com.payment.api.web.controller


import com.payment.api.service.ExpenseService
import com.payment.api.service.dto.ExpenseReportDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.Month

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment", description = "Payments Manager")
@Api(description = "API Payments Manager", tags = [("Payment API - Gerenciar Pagamentos")])
class PaymentController(
    private val expenseService: ExpenseService
) {

    @GetMapping("/")
    @ApiOperation("")
    fun findAll(): ResponseEntity<ExpenseReportDTO> {
        return ResponseEntity(
            expenseService.expenseReport(
                LocalDateTime.of(2024, Month.MARCH,13, 0, 0),
                LocalDateTime.of(2024, Month.MARCH,13, 0, 0)),
            HttpStatus.OK
        )
    }
}