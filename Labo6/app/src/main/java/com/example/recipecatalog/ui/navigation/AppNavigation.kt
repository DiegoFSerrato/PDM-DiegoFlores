package com.example.recipecatalog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.runtime.NavEntry
import com.example.recipecatalog.ui.screens.MealListScreen

@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<Any>("MealList") }

    NavDisplay(
        backStack = backStack,
        onBack = { 
            if (backStack.size > 1) {
                backStack.removeLast()
            }
        },
        entryProvider = { key ->
            NavEntry(key) {
                MealListScreen()
            }
        }
    )
}
