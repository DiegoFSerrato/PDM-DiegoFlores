package com.example.recipecatalog.data.repository

import com.example.recipecatalog.data.api.KtorClient
import com.example.recipecatalog.data.api.MealResponseDto
import com.example.recipecatalog.data.api.toModel
import com.example.recipecatalog.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get

class MealRepositoryImpl : MealRepository {
    override suspend fun getMeals(query: String): Result<List<Meal>> {
        return try {
            val response: MealResponseDto = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=$query")
                .body()
            
            val meals = response.meals?.map { it.toModel() } ?: emptyList()
            Result.success(meals)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
