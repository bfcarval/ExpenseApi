package com.expense.api.exception

class ExpenseIdInvalidException : RuntimeException {

    constructor(message: String, exception: Exception) : super(message, exception) {}
    constructor(message: String) : super(message) {}
}