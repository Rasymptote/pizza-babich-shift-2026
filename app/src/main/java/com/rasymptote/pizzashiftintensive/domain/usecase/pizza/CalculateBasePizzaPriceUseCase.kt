package com.rasymptote.pizzashiftintensive.domain.usecase.pizza

import com.rasymptote.pizzashiftintensive.domain.model.pizza.Pizza

class CalculateBasePizzaPriceUseCase {
    operator fun invoke(pizza: Pizza): Int =
        pizza.sizes.minOfOrNull { it.price } ?: 0
}