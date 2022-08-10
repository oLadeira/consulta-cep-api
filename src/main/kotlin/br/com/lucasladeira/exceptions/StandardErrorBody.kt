package br.com.lucasladeira.exceptions

import java.time.LocalDateTime

data class StandardErrorBody(
    var httpCode: Int,
    var message: String,
    var timeStamp: LocalDateTime,
    var internalCode: String
)