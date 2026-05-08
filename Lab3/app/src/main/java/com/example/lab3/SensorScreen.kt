package com.example.lab3

import android.hardware.Sensor
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SensorScreen() {
    val proximityValues = useSensor(Sensor.TYPE_PROXIMITY)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sensor de Proximidad",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(32.dp))

        if (proximityValues.isNotEmpty()) {
            Text(
                text = "Distancia: ${proximityValues[0]} cm",
                fontSize = 22.sp,
                color = Color(0xFF4B5A96),
                fontWeight = FontWeight.Medium
            )
        } else {
            Text(
                text = "Tu dispositivo no cuenta con sensor de proximidad.",
                fontSize = 16.sp,
                color = Color.Red
            )
        }
    }
}