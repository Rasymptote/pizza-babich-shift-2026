package com.rasymptote.pizzashiftintensive.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaComponentDto(
    @SerialName("img")
    val img: String,
    @SerialName("price")
    val price: Int,
    @SerialName("type")
    val type: String
)