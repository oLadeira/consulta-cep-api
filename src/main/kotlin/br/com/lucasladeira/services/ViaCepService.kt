package br.com.lucasladeira.services

import br.com.lucasladeira.entities.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    @GET("ws/{cep}/json")
    fun getAddressByCep(@Path("cep") cep: String): Call<Address>

    @GET("ws/{stateAbbreviation}/{cityName}/{streetName}/json")
    fun getAddressByStreetName(
        @Path("stateAbbreviation") stateAbbreviation: String,
        @Path("cityName") cityName: String,
        @Path("streetName") streetName: String
    ): Call<List<Address>>
}