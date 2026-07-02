package com.rasymptote.pizzashiftintensive.domain.pricing

import com.rasymptote.pizzashiftintensive.domain.exception.BasePriceNotFoundException
import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.model.Size

class SmallestSizeBasedPricing : BasePriceCalculator {
    override fun calculate(pizza: Pizza): Int {
        return pizza.sizes
            .firstOrNull { it.type == Size.SMALL }
            ?.price
            ?: throw BasePriceNotFoundException(pizza.id)
    }
}