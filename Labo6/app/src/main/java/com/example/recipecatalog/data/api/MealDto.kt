package com.example.recipecatalog.data.api

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import com.example.recipecatalog.data.model.Meal

@Serializable
data class MealResponseDto(
    val meals: List<MealDto>?
)

@Serializable
data class MealDto(
    @SerialName("idMeal") val idMeal: String?,
    @SerialName("strMeal") val strMeal: String?,
    @SerialName("strCategory") val strCategory: String?,
    @SerialName("strArea") val strArea: String?,
    @SerialName("strMealThumb") val strMealThumb: String?
)

fun MealDto.toModel(): Meal {
    return Meal(
        id = idMeal ?: "",
        name = strMeal ?: "Sin nombre",
        category = strCategory ?: "Desconocida",
        area = strArea ?: "Desconocido",
        imageUrl = strMealThumb ?: ""
    )
}
