package com.expense.api.database.repository

import com.expense.api.database.entity.ExpenseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ExpenseRepository : JpaRepository<ExpenseEntity, Long> {

    @Query("SELECT * FROM TB_EXPENSE WHERE CREATED_DATE >= :initDate AND CREATED_DATE <= :endDate"
        , nativeQuery = true
    )
    fun findByBetweenDates(@Param("initDate") initialDatetime: LocalDateTime,
                           @Param("endDate") endDatetime: LocalDateTime
    ): MutableList<ExpenseEntity>
}