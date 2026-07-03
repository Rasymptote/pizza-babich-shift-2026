package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.domain.mapper.BasePricedPizzaMapper
import com.rasymptote.pizzashiftintensive.domain.pricing.BasePriceCalculator
import com.rasymptote.pizzashiftintensive.domain.pricing.SmallestSizeBasedPricing
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import com.rasymptote.pizzashiftintensive.domain.usecase.GetBasePricedPizzasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

        @Provides
        fun provideBasePriceCalculator(): BasePriceCalculator =
            SmallestSizeBasedPricing()

        @Provides
        fun provideBasePricedPizzaMapper(
            basePriceCalculator: BasePriceCalculator
        ): BasePricedPizzaMapper =
            BasePricedPizzaMapper(basePriceCalculator)

        @Provides
        fun provideGetBasePricedPizzaUseCase(
            pizzaRepository: PizzaRepository,
            basePricedPizzaMapper: BasePricedPizzaMapper
        ): GetBasePricedPizzasUseCase =
            GetBasePricedPizzasUseCase(pizzaRepository, basePricedPizzaMapper)
}
