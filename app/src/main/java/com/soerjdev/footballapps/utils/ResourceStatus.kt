package com.soerjdev.footballapps.utils

sealed class ResourceStatus<T>(
    data: T? = null,
    message: String? = null
) {
    class Loading<T>(): ResourceStatus<T>()
    class Success<T>(data: T?): ResourceStatus<T>(data)
    class Error<T>(message: String?): ResourceStatus<T>(message = message)
}