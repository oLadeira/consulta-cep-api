package br.com.lucasladeira.dto

data class AddressDTO(
    var cep: String?=null,
    var logradouro: String?=null,
    var complemento: String?=null,
    var bairro: String?=null,
    var localidade: String?=null,
    var uf: String?=null,
    var ddd: String?=null
)