package app.petermiklanek.currency.data.remote

import android.content.res.Resources
import app.petermiklanek.currency.data.model.CurrenciesResponse
import com.thefuntasty.oneticket.data.remote.ApiExecutor
import javax.inject.Inject

class ApiManager @Inject constructor(
    private val apiService: ApiService,
    resources: Resources
) : ApiExecutor(resources) {

    suspend fun getCurrencies(accessKey: String): CurrenciesResponse =
        executeApiCall { apiService.getCurrencies(accessKey) }
}
