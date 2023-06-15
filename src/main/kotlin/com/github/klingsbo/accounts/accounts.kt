package com.github.klingsbo.accounts

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.ZonedDateTime
import java.util.*

@Entity
class Account : PanacheEntityBase {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    lateinit var id: UUID

    @Column(name = "email")
    lateinit var email: String

    @Column(name = "created_at")
    lateinit var createdAt: ZonedDateTime

    @Column(name = "updated_at")
    var updatedAt: ZonedDateTime? = null

    @Column(name = "deleted_at")
    var deletedAt: ZonedDateTime? = null

    constructor()

    companion object : PanacheCompanion<Account> {
        fun findByEmail(email: String) = Account.find("email", email).firstResult()
    }
}

data class AccountDto(
    val id: UUID,
    val email: String,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime?
)

data class CreateAccountDto(@JsonProperty("email") val email: String)

