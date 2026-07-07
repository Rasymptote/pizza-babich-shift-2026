package com.rasymptote.pizzashiftintensive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

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
}