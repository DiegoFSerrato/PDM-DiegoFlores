package com.example.labo2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.labo2.ui.theme.Labo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labo2Theme {
                MainScreenScaffold()
            }
        }
    }
}
@Composable
fun MainScreenScaffold() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
    ) { paddingValues ->
        ContenidoListaNombres(modifier = Modifier.padding(paddingValues))
    }
}
@Composable
fun ContenidoListaNombres(modifier: Modifier = Modifier) {
    var nombreInput by remember { mutableStateOf("") }
    val listaNombres = remember { mutableStateListOf<String>() }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombreInput,
            onValueChange = { nombreInput = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color(232, 252, 255),
                unfocusedContainerColor = Color(225, 229, 230)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (nombreInput.isNotBlank()) {
                    listaNombres.add(nombreInput.trim())
                    nombreInput = ""
                } else {
                    Toast.makeText(context, "Rellene los campos", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(54, 94, 181))
        ) {
            Text("Guardar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Listado de nombres y\nposición en la lista", style = MaterialTheme.typography.bodyMedium)
            Button(
                onClick = { listaNombres.clear() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(54, 94, 181))
            ) {
                Text("Limpiar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Blue, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            LazyColumn {
                itemsIndexed(listaNombres) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
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