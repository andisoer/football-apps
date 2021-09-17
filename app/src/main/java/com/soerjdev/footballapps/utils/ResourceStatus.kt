package com.soerjdev.footballapps.utils

sealed class ResourceStatus<T>(
    data: T? = null,
    message: String? = null
) {
    class Loading<T> : ResourceStatus<T>()
    data class Success<T>(val data: T?): ResourceStatus<T>(data = data)
    data class Error<T>(val message: String?): ResourceStatus<T>(message = message)
}