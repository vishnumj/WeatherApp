package com.example.weatherapp.ui.screens

//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LocationSearchScreen(onLocationSelected: (String) -> Unit) {
    var location by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Search Location") }) }
    ) {
        Column {
            TextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Enter Location") }
            )
            Button(onClick = { onLocationSelected(location) }) {
                Text("Confirm")
            }
        }
    }
}