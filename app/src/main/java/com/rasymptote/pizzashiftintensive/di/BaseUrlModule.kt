package com.rasymptote.pizzashiftintensive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PizzaApiBaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ImageBaseUrl

@Module
@InstallIn(SingletonComponent::class)
object BaseUrlModule {

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
}