package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.pricing.BasePriceCalculator
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class GetPricedPizzasUseCase(
    private val pizzaRepository: PizzaRepository,
    private val basePriceCalculator: BasePriceCalculator
) {
    suspend operator fun invoke(): List<PizzaWithBasePrice> =
        pizzaRepository.getAll().map {
            PizzaWithBasePrice(
                pizza = it,
                price = basePriceCalculator.calculate(it)
            )
        }
}

