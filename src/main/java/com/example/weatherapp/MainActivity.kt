package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.weatherapp.ui.WeatherViewModel
import com.example.weatherapp.ui.screens.LocationSearchScreen
import com.example.weatherapp.ui.screens.WeatherScreen
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.data.remote.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://dataservice.accuweather.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(WeatherApiService::class.java)
        val repository = WeatherRepositoryImpl(apiService)
        val viewModel = WeatherViewModel(repository)
        setContent {
            WeatherApp(viewModel)
        }
    }
}

@Composable
fun WeatherApp(viewModel: WeatherViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "weather") {
        composable("weather") {
            WeatherScreen(
                viewModel = viewModel,
                onLocationChange = { navController.navigate("search") }
            )
        }
        composable("search") {
            LocationSearchScreen { location ->
                viewModel.fetchWeather(location)
                navController.popBackStack()
            }
        }
    }
}
