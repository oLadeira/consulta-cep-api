package br.com.lucasladeira.services

import br.com.lucasladeira.entities.Address

interface AddressService {
    fun getAddressByCep(cep: String): Address?
}