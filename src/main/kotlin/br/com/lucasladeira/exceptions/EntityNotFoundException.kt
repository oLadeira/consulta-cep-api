package br.com.lucasladeira.exceptions

class EntityNotFoundException(
    override val message: String,
    val errorCode: String
): Exception() {
}