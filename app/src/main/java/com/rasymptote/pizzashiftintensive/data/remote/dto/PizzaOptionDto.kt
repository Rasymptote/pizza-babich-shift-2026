package com.rasymptote.pizzashiftintensive.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaOptionDto(
    @SerialName("price")
    val price: Int,
    @SerialName("type")
    val type: String
)