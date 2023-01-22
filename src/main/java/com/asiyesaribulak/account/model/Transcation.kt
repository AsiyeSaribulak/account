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
    constructor(amount: BigDecimal, transcationDate: LocalDateTime, account: Account) : this(
        id = null,
        amount = amount,
        transcationDate = transcationDate,
        transcationType = TranscationType.INITIAL,
        account = account
    )
    override fun equals(other: Any?): Boolean {
        if(this===other) return true
        if(javaClass !=other?.javaClass) return false

        other as Transcation

        if(id != other.id) return false
        if (transcationType != other.amount) return false
        if (amount != other.amount) return false
        if (transcationDate != other.transcationDate) return false
        if(account != other.account) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result=31*result+(transcationType?.hashCode() ?: 0)
        result=31*result + (amount?.hashCode() ?: 0)
        result=31*result+(transcationDate?.hashCode() ?: 0)
        return result
    }

}
enum class TranscationType{
    INITIAL,TRANSFER
}