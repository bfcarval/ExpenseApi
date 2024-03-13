package com.payment.api.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "TB_EXPENSE")
data class ExpenseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    internal val id: Long? = null,

    @Column(name = "PERSON_NAME")
    internal var personName: String? = null,

    @Column(name = "DESCRIPTION")
    internal var description: String? = null,

    @Column(name = "AMOUNT")
    internal var amount: BigDecimal = BigDecimal.ZERO,

    @Column(name = "TAGS")
    internal var tags: String? = null,

    @CreationTimestamp
    @Column(name = "CREATED_DATE", nullable = false)
    internal var createdDate: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    internal val updatedDate: LocalDateTime? = null
)