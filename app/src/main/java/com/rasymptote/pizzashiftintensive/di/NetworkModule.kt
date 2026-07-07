package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.data.remote.PizzaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providePizzaApiService(
        retrofit: Retrofit
    ): PizzaApiService =
        retrofit.create(PizzaApiService::class.java)
}