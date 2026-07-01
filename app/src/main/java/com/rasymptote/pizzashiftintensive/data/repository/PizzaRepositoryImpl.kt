package com.rasymptote.pizzashiftintensive.data.repository

import com.rasymptote.pizzashiftintensive.data.exception.ApiException
import com.rasymptote.pizzashiftintensive.data.mapper.toPizzas
import com.rasymptote.pizzashiftintensive.data.remote.PizzaApiService
import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository

class PizzaRepositoryImpl(
    private val pizzaApiService: PizzaApiService
) : PizzaRepository {

    override suspend fun getAll(): List<Pizza> {
        val response = pizzaApiService.getPizzas()

        if (!response.success) {
            throw ApiException(response.reason ?: "Unknown server error")
        }
        return response.toPizzas()
    }
}