package com.payment.api.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
@Api(value = "Payment Controller", description = "API Gerencimaneto de Pagamentos", tags = [("Payment API - Gerenciar Pagamentos")])
class PaymentController {

    @GetMapping("/")
    @ApiOperation("")
    fun findAll(): ResponseEntity<String> {
        return ResponseEntity.ok("Tudo OK")
    }
}