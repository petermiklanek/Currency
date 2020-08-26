package app.petermiklanek.currency.data.remote

import app.petermiklanek.currency.data.model.CurrenciesResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET

interface ApiService {

    @GET("latest")
    suspend fun getCurrencies(
        @Field("access_key") accessKey: String
    ): Response<CurrenciesResponse>
}
