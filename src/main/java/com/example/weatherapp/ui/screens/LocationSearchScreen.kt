package com.example.weatherapp.ui.screens

import android.annotation.SuppressLint
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column

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