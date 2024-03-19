package com.expense.api.database.repository

import com.expense.api.database.entity.ExpenseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ExpenseRepository : JpaRepository<ExpenseEntity, Long> {

    fun findByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(
        @Param("initDate") initialDatetime: LocalDateTime,
        @Param("endDate") endDatetime: LocalDateTime
    ): MutableList<ExpenseEntity>
}