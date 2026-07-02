package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import com.rasymptote.pizzashiftintensive.domain.usecase.GetAllPizzasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideGetAllPizzasUseCase(
        repository: PizzaRepository
    ) : GetAllPizzasUseCase = GetAllPizzasUseCase(repository)
}
