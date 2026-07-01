package com.rasymptote.pizzashiftintensive.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaDto(
    @SerialName("allergens")
    val allergens: List<String>,
    @SerialName("calories")
    val calories: Int,
    @SerialName("carbohydrates")
    val carbohydrates: String,
    @SerialName("description")
    val description: String,
    @SerialName("doughs")
    val doughs: List<PizzaOptionDto>,
    @SerialName("id")
    val id: String,
    @SerialName("img")
    val img: String,
    @SerialName("ingredients")
    val ingredients: List<PizzaComponentDto>,
    @SerialName("isGlutenFree")
    val isGlutenFree: Boolean,
    @SerialName("isHit")
    val isHit: Boolean,
    @SerialName("isNew")
    val isNew: Boolean,
    @SerialName("isVegetarian")
    val isVegetarian: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("protein")
    val protein: String,
    @SerialName("sizes")
    val sizes: List<PizzaOptionDto>,
    @SerialName("sodium")
    val sodium: String,
    @SerialName("toppings")
    val toppings: List<PizzaComponentDto>,
    @SerialName("totalFat")
    val totalFat: String
)