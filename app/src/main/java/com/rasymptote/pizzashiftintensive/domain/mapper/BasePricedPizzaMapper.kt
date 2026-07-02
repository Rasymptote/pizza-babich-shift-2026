package com.rasymptote.pizzashiftintensive.domain.mapper

import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.pricing.BasePriceCalculator
import com.rasymptote.pizzashiftintensive.domain.usecase.PricedPizza

class BasePricedPizzaMapper(
    private val basePriceCalculator: BasePriceCalculator
) {
    fun map(pizza: Pizza): PricedPizza =
        PricedPizza(
            pizza = pizza,
            price = basePriceCalculator.calculate(pizza)
        )
}