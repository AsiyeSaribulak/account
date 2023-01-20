package com.asiyesaribulak.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Transcation(
    @Id
    @GeneratedValue(generator = "UUID") //tahmin edilemeyen harf ve rakamlardan oluşan id üretir
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val transcationType: TranscationType?=TranscationType.INITIAL,
    val amount:BigDecimal?,
    val transcationDate: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account?
) {

}
enum class TranscationType{
    INITIAL,TRANSFER
}