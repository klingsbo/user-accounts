package com.github.klingsbo.accounts

import io.quarkus.hibernate.orm.panache.PanacheEntity
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.ZonedDateTime
import java.util.UUID

@Entity
class Account : PanacheEntity {
    lateinit var email: String
//    TODO not generated automatically, but should
    var createdAt: ZonedDateTime? = null

    var firstName: String? = null
    var lastName: String? = null
    var updatedAt: ZonedDateTime? = null
    var deletedAt: ZonedDateTime? = null

    constructor()
}

data class AccountDto(
    val id: Long,
    val email: String,
    val createdAt: ZonedDateTime?,
    val firstName: String?,
    val lastName: String?
)

data class CreateAccountDto(val email: String, val firstName: String?, val lastName: String?)

