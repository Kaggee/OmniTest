package com.example.omnitest.api

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
sealed class ApiResultWrapper<out T> {
    data class Success<out T>(val value: T): ApiResultWrapper<T>()
    data class GenericError(val code: Int?, val message: String?): ApiResultWrapper<Nothing>()
    object NetworkError: ApiResultWrapper<Nothing>()
}