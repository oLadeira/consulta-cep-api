package br.com.lucasladeira.services

import br.com.lucasladeira.dto.AddressDTO
import br.com.lucasladeira.entities.Address

interface AddressService {
    fun getAddressByCep(cep: String): AddressDTO?
    fun getAddressByStreetName(
        stateAbbreviation: String,
        cityName: String,
        streetName: String): List<AddressDTO>?
}