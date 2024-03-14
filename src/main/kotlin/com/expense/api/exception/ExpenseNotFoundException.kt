package com.expense.api.exception

class ExpenseNotFoundException : RuntimeException {

    constructor(message: String, exception: Exception) : super(message, exception) {}
    constructor(message: String) : super(message) {}
}