package com.asiyesaribulak.account.dto

import com.asiyesaribulak.account.model.TranscationType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TranscationDto(
    val id: String?,
    val transcationType: TranscationType? = TranscationType.INITIAL,
    val amount: BigDecimal?,
    val transcationDate: LocalDateTime?
) {
}