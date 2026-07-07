package com.rasymptote.pizzashiftintensive.data.repository

import com.rasymptote.pizzashiftintensive.data.exception.ApiException
import com.rasymptote.pizzashiftintensive.data.mapper.PizzaMapper
import com.rasymptote.pizzashiftintensive.data.remote.PizzaApiService
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import com.rasymptote.pizzashiftintensive.domain.exception.PizzaNotFoundException
import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val pizzaApiService: PizzaApiService,
    private val mapper: PizzaMapper
) : PizzaRepository {

    private var cachedCatalog: PizzaCatalogResponseDto? = null

    override suspend fun getAll(): List<Pizza> =
        mapper.map(getCatalog())

    override suspend fun getById(id: String): Pizza =
        getCatalog()
            .catalog
            .firstOrNull { it.id == id }
            ?.let(mapper::map)
            ?: throw PizzaNotFoundException(id)

    private suspend fun getCatalog(): PizzaCatalogResponseDto {
        cachedCatalog?.let { return it }

        val response = pizzaApiService.getPizzas()

        if (!response.success) {
            throw ApiException(response.reason ?: "Unknown server error")
        }

        cachedCatalog = response

        return response
    }
}