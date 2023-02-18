package com.example.omnitest.api

import com.example.omnitest.utils.log
import com.example.omnitest.utils.logError
import retrofit2.HttpException

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
abstract class BaseRepository {
    protected suspend fun <T> safeApiCall(call: suspend() -> T): ApiResultWrapper<T> {
        return try {
            ApiResultWrapper.Success(call.invoke())
        } catch (t: Throwable) {
            val callName = call::class.java.name
            t.logError()
            "Api Error in call: $callName".log()

            return when(t) {
                is HttpException -> {
                    ApiResultWrapper.GenericError(t.code(), t.message())
                }
                else -> ApiResultWrapper.NetworkError
            }
        }
    }
}