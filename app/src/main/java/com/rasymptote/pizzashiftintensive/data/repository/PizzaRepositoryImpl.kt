package com.rasymptote.pizzashiftintensive.data.repository

import com.rasymptote.pizzashiftintensive.data.exception.ApiException
import com.rasymptote.pizzashiftintensive.data.mapper.PizzaMapper
import com.rasymptote.pizzashiftintensive.data.remote.PizzaApiService
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val pizzaApiService: PizzaApiService,
    private val mapper: PizzaMapper
) : PizzaRepository {

    override suspend fun getAll() =
        mapper.map(getCatalog())

    override suspend fun getById(id: String) =
        getCatalog()
            .catalog
            .firstOrNull { it.id == id }
            ?.let(mapper::map)

    private suspend fun getCatalog() =
        pizzaApiService.getPizzas().also {
            if (!it.success) {
                throw ApiException(it.reason ?: "Unknown server error")
            }
        }
}