package com.dub.domain.common

sealed class ResultState<T> {

    data class Success<T>(val data: T) : ResultState<T>()
    data class Error<T>(val error: String) : ResultState<T>()

}