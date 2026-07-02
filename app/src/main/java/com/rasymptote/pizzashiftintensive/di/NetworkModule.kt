package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.data.remote.PizzaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PizzaApiBaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ImageBaseUrl

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @PizzaApiBaseUrl
    fun providePizzaApiBaseUrl(): HttpUrl =
        "https://juniorsbootcamp.ru/api/pizza/".toHttpUrl()

    @Provides
    @Singleton
    @ImageBaseUrl
    fun provideImageBaseUrl(): HttpUrl =
        "https://juniorsbootcamp.ru/api/".toHttpUrl()

    @Provides
    @Singleton
    fun provideJson(): Json =
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

    @Provides
    @Singleton
    fun provideConverterFactory(json: Json): Converter.Factory =
        json.asConverterFactory(
            "application/json".toMediaType()
        )

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @PizzaApiBaseUrl baseUrl: HttpUrl,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): PizzaApiService =
        retrofit.create(PizzaApiService::class.java)
}