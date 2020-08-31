package app.petermiklanek.currency.data.remote

import app.petermiklanek.currency.data.model.response.CurrenciesResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("latest")
    suspend fun getCurrencies(
        @Query("access_key") accessKey: String
    ): Response<CurrenciesResponse>
}
