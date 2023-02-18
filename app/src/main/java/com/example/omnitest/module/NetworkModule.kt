package com.example.omnitest.module

import com.example.omnitest.api.NewsApi
import com.example.omnitest.api.NewsRepository
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */


val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideTikXml() }
    factory { provideRetrofit( get(), get() ) }
    factory { provideNewsApi( get() ) }
    factory { NewsRepository(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideTikXml(): TikXml {
    return TikXml.Builder().exceptionOnUnreadXml(false).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient, tikXml: TikXml): Retrofit {
    return Retrofit
        .Builder()
        .client(okHttpClient)
        .baseUrl("https://omni.se/")
        .addConverterFactory(TikXmlConverterFactory.create(tikXml))
        .build()
}

fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)