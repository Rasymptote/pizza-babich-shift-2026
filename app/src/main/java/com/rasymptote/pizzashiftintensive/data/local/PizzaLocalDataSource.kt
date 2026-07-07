package com.rasymptote.pizzashiftintensive.data.local

import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import jakarta.inject.Inject

class PizzaLocalDataSource @Inject constructor() {

    private var cachedCatalog: PizzaCatalogResponseDto? = null

    fun getCatalog(): PizzaCatalogResponseDto? = cachedCatalog

    fun saveCatalog(catalog: PizzaCatalogResponseDto) {
        cachedCatalog = catalog
    }
}