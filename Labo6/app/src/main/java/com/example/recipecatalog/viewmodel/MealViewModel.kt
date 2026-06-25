package com.example.recipecatalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecatalog.data.model.Meal
import com.example.recipecatalog.data.repository.MealRepository
import com.example.recipecatalog.data.repository.MealRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel(
    private val repository: MealRepository = MealRepositoryImpl()
) : ViewModel() {

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals: StateFlow<List<Meal>> = _meals.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun loadMeals(query: String = "") {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            repository.getMeals(query)
                .onSuccess {
                    _meals.value = it
                }
                .onFailure {
                    _errorMessage.value = "Error al cargar datos: ${it.message}"
                }
            
            _isLoading.value = false
        }
    }
}
