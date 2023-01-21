package com.asiyesaribulak.account.dto

import com.asiyesaribulak.account.model.Customer
import com.asiyesaribulak.account.model.Transcation
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
    val id: String?,
    val balance: BigDecimal?= BigDecimal.ZERO,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transcation:Set<TranscationDto?>
) {
}