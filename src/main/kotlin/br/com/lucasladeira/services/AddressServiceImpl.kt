package br.com.lucasladeira.services

import br.com.lucasladeira.config.RetrofitConfig
import br.com.lucasladeira.dto.AddressDTO
import br.com.lucasladeira.exceptions.EntityNotFoundException
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl: AddressService {

    @Autowired
    lateinit var retrofitConfig: RetrofitConfig
    @Autowired
    lateinit var mapper: ModelMapper
    private val BASE_URL = "https://viacep.com.br"
    private val logger = LoggerFactory.getLogger(AddressServiceImpl::class.java)

    override fun getAddressByCep(cep: String): AddressDTO?{
        val apiService = retrofitConfig
            .retrofit(BASE_URL)
            .create(ViaCepService::class.java)
        val apiCall = apiService.getAddressByCep(cep)
        val address = apiCall.execute().body()
        if (address == null) throw EntityNotFoundException("Endereço não encontrado!", "000")
        return mapper.map(address, AddressDTO::class.java)
    }

    override fun getAddressByStreetName(stateAbbreviation: String, cityName: String, streetName: String): List<AddressDTO>? {
        val apiService = retrofitConfig
            .retrofit(BASE_URL)
            .create(ViaCepService::class.java)
        val apiCall = apiService.getAddressByStreetName(stateAbbreviation, cityName, streetName)
        return apiCall.execute()
            .body()!!
            .map { address -> mapper.map(address, AddressDTO::class.java) }
    }
}