package com.rasymptote.pizzashiftintensive.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaCatalogResponseDto(
    val success: Boolean,
    val reason: String? = null,
    @SerialName("catalog")
    val catalog: List<PizzaDto>,
)