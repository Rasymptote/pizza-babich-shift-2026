package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.model.pizza.Pizza
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class GetPizzasUseCase(
    private val pizzaRepository: PizzaRepository,
) {
    suspend operator fun invoke(): List<Pizza> = pizzaRepository.getAll()
}
