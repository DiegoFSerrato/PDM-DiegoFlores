package com.example.lab3

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameListScreen() {
    var currentName by remember { mutableStateOf("") }
    var nameList by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = currentName,
            onValueChange = { currentName = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE5E5EA),
                unfocusedContainerColor = Color(0xFFE5E5EA),
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color(0xFF4B5A96)
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (currentName.isNotBlank()) {
                    nameList = nameList + currentName
                    currentName = ""
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B5A96))
        ) {
            Text("Guardar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Listado de nombres y\nposición en la lista",
                modifier = Modifier.weight(1f),
                fontSize = 14.sp,
                color = Color.DarkGray
            )

            Button(
                onClick = {
                    nameList = emptyList()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B5A96))
            ) {
                Text("Limpiar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(nameList) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item, color = Color.Black)
                        Text(text = "${index + 1}", color = Color.Black)
                    }
                }
            }
        }
    }
}