package com.example.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab3.ui.theme.Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    //Oobjeto Home
                    NavHost(navController = navController, startDestination = Home) {

                        // composable Home
                        composable<Home> {
                            HomeScreen(
                                onNavigateToNames = { navController.navigate(Names) },
                                onNavigateToSensor = { navController.navigate(Sensor) }
                            )
                        }

                        // Nombres
                        composable<Names> {
                            NameListScreen()
                        }

                        // Sensores
                        composable<Sensor> {
                            SensorScreen()
                        }
                    }
                }
            }
        }
    }
}