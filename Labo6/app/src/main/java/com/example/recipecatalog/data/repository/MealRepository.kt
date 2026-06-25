package com.example.recipecatalog.data.repository

import com.example.recipecatalog.data.model.Meal

interface MealRepository {
    suspend fun getMeals(query: String = ""): Result<List<Meal>>
}
