package com.asiyesaribulak.account.dto

import java.math.BigDecimal

data class CreateAccountRequest(
    val id : String,
    val initialCredit : BigDecimal
) {
}