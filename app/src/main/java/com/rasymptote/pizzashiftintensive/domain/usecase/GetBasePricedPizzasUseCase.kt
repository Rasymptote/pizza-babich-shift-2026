package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.mapper.BasePricedPizzaMapper
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class GetBasePricedPizzasUseCase(
    private val pizzaRepository: PizzaRepository,
    private val basePricedPizzaMapper: BasePricedPizzaMapper
) {
    suspend operator fun invoke() : List<PricedPizza> =
        pizzaRepository.getAll().map(basePricedPizzaMapper::map)
}

