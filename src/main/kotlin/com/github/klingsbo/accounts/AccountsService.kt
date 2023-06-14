package com.github.klingsbo.accounts

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import java.util.*

@ApplicationScoped
class AccountsService {

    @Transactional
    fun createAccount(createAccountDto: CreateAccountDto): AccountDto {
        val account = Account().apply {
            email = createAccountDto.email
            firstName = createAccountDto.firstName
            lastName = createAccountDto.lastName
        }
        account.persist()
        return AccountDto(account.id, account.email, account.createdAt, account.firstName, account.lastName)
    }

}
