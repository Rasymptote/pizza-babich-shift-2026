package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.domain.pricing.BasePriceCalculator
import com.rasymptote.pizzashiftintensive.domain.pricing.SmallestSizeBasedPricing
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import com.rasymptote.pizzashiftintensive.domain.usecase.GetAllPizzasUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.GetPricedPizzasUseCase
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
        ): GetAllPizzasUseCase = GetAllPizzasUseCase(repository)

        @Provides
        fun provideBasePriceCalculator(): BasePriceCalculator =
            SmallestSizeBasedPricing()

        @Provides
        fun provideGetAllPizzasWithBasePriceUseCase(
            useCase: GetAllPizzasUseCase,
            strategy: BasePriceCalculator
        ): GetPricedPizzasUseCase =
            GetPricedPizzasUseCase(useCase, strategy)
}
