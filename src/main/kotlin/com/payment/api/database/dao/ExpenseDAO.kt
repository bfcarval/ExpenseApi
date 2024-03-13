package com.payment.api.database.dao

import com.payment.api.database.entity.ExpenseEntity
import com.payment.api.database.repository.ExpenseRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.Optional

@Component
class ExpenseDAO(private val expenseRepository: ExpenseRepository) {

    @Transactional(propagation = Propagation.REQUIRED)
    fun create(expense: ExpenseEntity): ExpenseEntity = expenseRepository.save(expense)

    @Transactional(propagation = Propagation.REQUIRED)
    fun update(expense: ExpenseEntity): ExpenseEntity = expenseRepository.save(expense)

    @Transactional(propagation = Propagation.REQUIRED)
    fun delete(id: Long?) = expenseRepository.deleteById(id?:0L)

    @Transactional(propagation = Propagation.SUPPORTS)
    fun findById(id: Long?): Optional<ExpenseEntity> = expenseRepository.findById(id?:0L)

    @Transactional(propagation = Propagation.SUPPORTS)
    fun findAll(): MutableList<ExpenseEntity> = expenseRepository.findAll()

    @Transactional(propagation = Propagation.SUPPORTS)
    fun findByDates(initialDateTime: LocalDateTime, endDatetime: LocalDateTime): MutableList<ExpenseEntity> =
        expenseRepository.findByBetweenDates(initialDateTime, endDatetime)
}