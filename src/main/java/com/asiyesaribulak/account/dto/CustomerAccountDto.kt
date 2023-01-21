package com.asiyesaribulak.account.dto

import com.asiyesaribulak.account.model.Transcation
import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val id: String?,
    val balance: BigDecimal?= BigDecimal.ZERO,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transcation:Set<TranscationDto?>
){
}