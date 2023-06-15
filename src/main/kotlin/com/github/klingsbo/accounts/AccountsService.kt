package com.github.klingsbo.accounts

import com.github.klingsbo.accounts.exceptions.AccountAlreadyExistsException
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import java.time.ZonedDateTime
import java.util.*

@ApplicationScoped
class AccountsService {

    @Transactional
    fun createAccount(email: String): AccountDto {
        if (Account.findByEmail(email) != null) {
            throw AccountAlreadyExistsException("Email $email already exists")
        }

        val entity = Account().apply {
            this.email = email
            this.createdAt = ZonedDateTime.now()
        }
        entity.persist()

        return AccountDto(entity.id, entity.email, entity.createdAt, entity.updatedAt)
    }

}
