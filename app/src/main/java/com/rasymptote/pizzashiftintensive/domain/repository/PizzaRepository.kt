package com.rasymptote.pizzashiftintensive.domain.repository

import com.rasymptote.pizzashiftintensive.domain.model.Pizza

interface PizzaRepository {
    suspend fun getAll(): List<Pizza>

    suspend fun getById(id: String): Pizza
}