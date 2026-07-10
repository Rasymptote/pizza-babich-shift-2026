package com.rasymptote.pizzashiftintensive.data.repository

import com.rasymptote.pizzashiftintensive.data.local.PizzaLocalDataSource
import com.rasymptote.pizzashiftintensive.data.mapper.PizzaMapper
import com.rasymptote.pizzashiftintensive.data.remote.PizzaRemoteDataSource
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import com.rasymptote.pizzashiftintensive.domain.exception.PizzaNotFoundException
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Pizza
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val localDataSource: PizzaLocalDataSource,
    private val remoteDataSource: PizzaRemoteDataSource,
    private val mapper: PizzaMapper
) : PizzaRepository {

    override suspend fun getAll(): List<Pizza> =
        mapper.map(getCatalog())

    override suspend fun getById(id: String): Pizza =
        getCatalog()
            .catalog
            .firstOrNull { it.id == id }
            ?.let(mapper::map)
            ?: throw PizzaNotFoundException(id)

    private suspend fun getCatalog(): PizzaCatalogResponseDto {
        localDataSource.getCatalog()?.let { return it }

        val catalog = remoteDataSource.getCatalog()

        localDataSource.saveCatalog(catalog)

        return catalog
    }
}