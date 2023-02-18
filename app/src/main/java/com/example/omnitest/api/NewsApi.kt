package com.example.omnitest.api

import com.example.omnitest.model.NewsWrapper
import retrofit2.http.GET

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */

interface NewsApi {

    @GET("rss")
    suspend fun getNews(): NewsWrapper
}