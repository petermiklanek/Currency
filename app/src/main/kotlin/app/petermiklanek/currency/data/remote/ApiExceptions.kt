package app.petermiklanek.currency.data.remote

sealed class ApiException(message: String?) : Exception(message) {
    companion object {
        const val BAD_REQUEST = 400
        const val UNAUTHORIZED = 401
        const val NOT_FOUND = 404
    }
}

class ApiExceptionParseError(message: String) : ApiException(message)
class ApiExceptionConnectionError(message: String) : ApiException(message)
class ApiExceptionUnAuthorized(message: String) : ApiException(message)
class ApiExceptionUnknown(message: String) : ApiException(message)
class ApiExceptionBadRequest(message: String, val detailedMessage: String) : ApiException(message)
class ApiExceptionNotFound(message: String) : ApiException(message)
