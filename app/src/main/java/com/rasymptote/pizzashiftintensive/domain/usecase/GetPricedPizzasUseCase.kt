package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.pricing.BasePriceCalculator

class GetPricedPizzasUseCase(
    private val getAllPizzasUseCase: GetAllPizzasUseCase,
    private val strategy: BasePriceCalculator
) {
    suspend operator fun invoke(): List<PizzaWithBasePrice> =
        getAllPizzasUseCase().map { pizza ->
            PizzaWithBasePrice(
                pizza = pizza,
                price = strategy.calculate(pizza)
            )
        }
}
