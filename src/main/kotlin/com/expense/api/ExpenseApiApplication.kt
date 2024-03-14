package com.expense.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExpenseApiApplication

fun main(args: Array<String>) {
	runApplication<ExpenseApiApplication>(*args)
}
