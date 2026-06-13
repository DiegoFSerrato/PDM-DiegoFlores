package com.example.lab4.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.example.lab4.Tasks
import com.example.lab4.data.DefaultDataRepository
import com.example.lab4.theme.Lab4Theme

@Composable
fun MainScreen(
  onItemClick: (NavKey) -> Unit,
  modifier: Modifier = Modifier,
  viewModel: MainScreenViewModel = viewModel { MainScreenViewModel(DefaultDataRepository()) },
) {
  val state by viewModel.uiState.collectAsStateWithLifecycle()
  when (state) {
    MainScreenUiState.Loading -> {
      // Blank
    }
    is MainScreenUiState.Success -> {
      MainScreen(
        data = (state as MainScreenUiState.Success).data,
        onItemClick = onItemClick,
        modifier = modifier
      )
    }
    is MainScreenUiState.Error -> {
      Text("Error loading data: ${(state as MainScreenUiState.Error).throwable.message}")
    }
  }
}

@Composable
internal fun MainScreen(
  data: List<String>,
  onItemClick: (NavKey) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier) {
    data.forEach { Greeting(it) }
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = { onItemClick(Tasks) }) {
      Text("Ir a Tareas")
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(text = "Bienvenido al gestor de tareas", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
  Lab4Theme { MainScreen(data = listOf("Android"), onItemClick = {}) }
}

@Preview(showBackground = true, widthDp = 340)
@Composable
fun MainScreenPortraitPreview() {
  Lab4Theme { MainScreen(data = listOf("Android"), onItemClick = {}) }
}
