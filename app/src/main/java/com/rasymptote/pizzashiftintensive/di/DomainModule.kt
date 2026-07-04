package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import com.rasymptote.pizzashiftintensive.domain.usecase.CalculateBasePizzaPriceUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.GetPizzaByIdUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.GetPizzasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideCalculateBasePizzaPriceUseCase() : CalculateBasePizzaPriceUseCase =
        CalculateBasePizzaPriceUseCase()

    @Provides
    fun providePizzasUseCase(pizzaRepository: PizzaRepository): GetPizzasUseCase =
        GetPizzasUseCase(pizzaRepository)

    @Provides
    fun providePizzaByIdUseCase(pizzaRepository: PizzaRepository): GetPizzaByIdUseCase =
        GetPizzaByIdUseCase(pizzaRepository)

}
