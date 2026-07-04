package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class GetPizzaByIdUseCase(
    private val pizzaRepository: PizzaRepository,
) {
    suspend operator fun invoke(pizzaId: String): Pizza = pizzaRepository.getById(pizzaId)
}