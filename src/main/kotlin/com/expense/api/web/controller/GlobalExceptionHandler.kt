package com.expense.api.web.controller

import com.expense.api.exception.ExpenseIdInvalidException
import com.expense.api.exception.ExpenseNotFoundException
import com.expense.api.exception.data.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ExpenseIdInvalidException::class)
    fun handleExpenseIdInvalidException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.message.orEmpty()
            ),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(ExpenseNotFoundException::class)
    fun handleExpenseNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.message.orEmpty()
            ),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.message.orEmpty()
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}