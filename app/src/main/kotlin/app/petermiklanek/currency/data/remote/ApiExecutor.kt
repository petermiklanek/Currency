package com.thefuntasty.oneticket.data.remote

import android.content.res.Resources
import app.petermiklanek.currency.R
import app.petermiklanek.currency.data.remote.*
import com.squareup.moshi.JsonDataException
import app.petermiklanek.currency.data.remote.ApiException.Companion.BAD_REQUEST
import app.petermiklanek.currency.data.remote.ApiException.Companion.NOT_FOUND
import app.petermiklanek.currency.data.remote.ApiException.Companion.UNAUTHORIZED
import retrofit2.Response
import timber.log.Timber
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

@Suppress("ThrowsCount")
open class ApiExecutor(private val res: Resources) {

    suspend fun <T> executeApiCall(apiCall: suspend () -> Response<T>): T {
        try {
            return apiCall().processResponse()
        } catch (e: ApiException) {
            throw e
        } catch (e: JsonDataException) {
            Timber.e(e)
            throw ApiExceptionParseError(res.getString(R.string.error_parse))
        } catch (e: KotlinNullPointerException) {
            throw e
        } catch (e: UnknownHostException) {
            Timber.e(e)
            throw ApiExceptionConnectionError(res.getString(R.string.error_connection))
        } catch (e: CancellationException) {
            throw e // This is normal way of cancelling coroutines, throw as-is, so CoroutineScopeOwner can properly handle it
        } catch (e: Exception) {
            Timber.e(e)
            throw ApiExceptionUnknown(res.getString(R.string.error_general_server_error))
        }
    }

    @Suppress("SwallowedException")
    suspend fun <T> executeNullableApiCall(apiCall: suspend () -> Response<T>): T? =
        try {
            executeApiCall(apiCall)
        } catch (e: KotlinNullPointerException) {
            null
        }

    @Suppress("UnsafeCallOnNullableType")
    private fun <T> Response<T>.processResponse(): T {
        if (isSuccessful) {
            return this.body()!!
        } else {
            parseError(this)
        }
    }

    private fun <T> parseError(response: Response<T>): Nothing {
        when (response.code()) {
            UNAUTHORIZED -> throw ApiExceptionUnAuthorized(res.getString(R.string.error_invalid_credentials))
            BAD_REQUEST -> throw ApiExceptionBadRequest(res.getString(R.string.error_bad_request), response.message())
            NOT_FOUND -> throw ApiExceptionNotFound(res.getString(R.string.error_data_not_found))
            else -> throw ApiExceptionUnknown(res.getString(R.string.error_general_server_error))
        }
    }
}
