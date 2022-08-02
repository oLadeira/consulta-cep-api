package br.com.lucasladeira.services

import br.com.lucasladeira.config.RetrofitConfig
import br.com.lucasladeira.entities.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import retrofit2.create

@Service
class AddressServiceImpl: AddressService {

    @Autowired
    lateinit var retrofitConfig: RetrofitConfig
    private val BASE_URL = "https://viacep.com.br"

    override fun getAddressByCep(cep: String): Address?{
        val apiService = retrofitConfig
            .retrofit(BASE_URL)
            .create(ViaCepService::class.java)
        val apiCall = apiService.getAddressByCep(cep)
        return apiCall.execute().body()
    }

    override fun getAddressByStreetName(stateAbbreviation: String, cityName: String, streetName: String): List<Address>? {
        val apiService = retrofitConfig
            .retrofit(BASE_URL)
            .create(ViaCepService::class.java)
        val apiCall = apiService.getAddressByStreetName(stateAbbreviation, cityName, streetName)
        return apiCall.execute().body()
    }
}