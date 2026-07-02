package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.exception.PizzaNotFoundException
import com.rasymptote.pizzashiftintensive.domain.mapper.BasePricedPizzaMapper
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class GetBasePricedPizzaByIdUseCase(
    private val pizzaRepository: PizzaRepository,
    private val basePricedPizzaMapper: BasePricedPizzaMapper
) {
    suspend operator fun invoke(pizzaId: String): PricedPizza {
        val pizza = pizzaRepository.getById(pizzaId)
            ?: throw PizzaNotFoundException(pizzaId)

        return basePricedPizzaMapper.map(pizza)
    }
}