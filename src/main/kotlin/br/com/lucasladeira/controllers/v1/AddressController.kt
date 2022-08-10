package br.com.lucasladeira.controllers.v1

import br.com.lucasladeira.dto.AddressDTO
import br.com.lucasladeira.entities.Address
import br.com.lucasladeira.services.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api/v1/adresses")
@Validated
class AddressController(
    @Autowired
    private val addressService: AddressService
) {
    @GetMapping("/{cep}")
    fun getAddressByCep(@PathVariable(name = "cep") @Size(max = 8, min = 8) cep: String): ResponseEntity<AddressDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressByCep(cep))
    }

    @GetMapping("/{stateAbreviation}/{cityName}/{streetName}")
    fun getAddressByStreetName(
        @PathVariable("stateAbreviation") @NotEmpty @Size(max = 2, min = 2) stateAbreviation: String,
        @PathVariable("cityName") cityName: String,
        @PathVariable("streetName") streetName: String): ResponseEntity<List<AddressDTO>>{
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressByStreetName(stateAbreviation, cityName, streetName))
    }
}