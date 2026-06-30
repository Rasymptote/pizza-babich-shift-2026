package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class GetAllPizzasUseCase(
    private val repository: PizzaRepository
) {
    suspend operator fun invoke() : List<Pizza> = repository.getAll()
}