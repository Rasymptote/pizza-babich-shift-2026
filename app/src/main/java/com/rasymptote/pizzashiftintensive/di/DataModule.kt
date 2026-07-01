package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.data.repository.PizzaRepositoryImpl
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindPizzaRepository(
        impl: PizzaRepositoryImpl
    ): PizzaRepository
}