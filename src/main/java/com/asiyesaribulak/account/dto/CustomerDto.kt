package com.asiyesaribulak.account.dto

import com.asiyesaribulak.account.model.Account

data class CustomerDto(
    val id: String?,
    val name:String?,
    val surname: String?,
    val account: Set<CustomerAccountDto>?
) {
}