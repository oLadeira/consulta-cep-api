package br.com.lucasladeira.controllers.v1

import br.com.lucasladeira.entities.Address
import br.com.lucasladeira.services.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/adresses")
class AddressController(
    @Autowired
    private val addressService: AddressService
) {
    @GetMapping("/{cep}")
    fun getAddressByCep(@PathVariable(name = "cep")cep: String): ResponseEntity<Address>{
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressByCep(cep))
    }

    @GetMapping("/{stateAbreviation}/{cityName}/{streetName}")
    fun getAddressByStreetName(
        @PathVariable("stateAbreviation") stateAbreviation: String,
        @PathVariable("cityName") cityName: String,
        @PathVariable("streetName") streetName: String): ResponseEntity<List<Address>>{
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressByStreetName(stateAbreviation, cityName, streetName))
    }
}