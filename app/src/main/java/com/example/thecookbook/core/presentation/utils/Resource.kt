package com.example.thecookbook.core.presentation.utils

sealed class Resource<T>(
    val data: T? = null,
    val errorMsg: String? = null,
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(data: T? = null, errorMsg: String) : Resource<T>(data, errorMsg)
    class Loading<T>(val isLoading: Boolean = false) : Resource<T>(null)
}