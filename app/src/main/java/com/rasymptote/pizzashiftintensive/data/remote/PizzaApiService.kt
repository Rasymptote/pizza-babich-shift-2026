package com.rasymptote.pizzashiftintensive.data.remote

import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import retrofit2.http.GET

interface PizzaApiService {

    @GET("/api/pizza/catalog")
    suspend fun getPizzas(): PizzaCatalogResponseDto
}