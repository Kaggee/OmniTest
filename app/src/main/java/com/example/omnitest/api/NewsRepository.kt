package com.example.omnitest.api

import com.example.omnitest.model.NewsModel

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
class NewsRepository(private val api: NewsApi): BaseRepository() {

    suspend fun getNews(): ApiResultWrapper<NewsModel> {
        return safeApiCall { api.getNews().newsModel }
    }
}