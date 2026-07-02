package com.rasymptote.pizzashiftintensive.domain.pricing

import com.rasymptote.pizzashiftintensive.domain.model.Pizza

sealed interface BasePriceCalculator {
    fun calculate(pizza: Pizza): Int
}