package com.example.weatherapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import com.example.weatherapp.ui.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun WeatherScreen(viewModel: WeatherViewModel, onLocationChange: () -> Unit) {
    val weather by viewModel.weatherState.collectAsState()
    val autoCompleteLocationResponse by viewModel.autoCompleteLocationState.collectAsState()

    viewModel.getAutoCompleteLocationDetails()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Bengaluru's Weather") })
        }
    ) {
        autoCompleteLocationResponse.firstOrNull()?.localizedName?.let { location ->
            viewModel.fetchWeather(location)
        }
        weather?.let {
            Column {
                Text(text = "Location: ${it.name}")
                Text(text = "Temperature: ${it.main.temp}°C")
                Text(text = "Condition: ${it.weather[0].description}")
                Button(onClick = onLocationChange) { Text("Change Location") }
            }
        } ?: Text("Loading...")
    }
}
@Preview
@Composable
fun PreviewWeatherScreen() {
    // Provide a preview for design time
}
