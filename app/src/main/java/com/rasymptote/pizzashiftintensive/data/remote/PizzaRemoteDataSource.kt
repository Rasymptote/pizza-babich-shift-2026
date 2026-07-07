package com.rasymptote.pizzashiftintensive.data.remote

import com.rasymptote.pizzashiftintensive.data.exception.ApiException
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import jakarta.inject.Inject

class PizzaRemoteDataSource @Inject constructor(
    private val pizzaApiService: PizzaApiService
) {

    suspend fun getCatalog(): PizzaCatalogResponseDto {
        val response = pizzaApiService.getPizzas()

        if (!response.success) {
            throw ApiException(response.reason ?: "Unknown server error")
        }

        return response
    }
}