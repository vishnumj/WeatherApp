package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.model.AutoCompleteLocationResponse
import com.example.weatherapp.data.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(location: String): WeatherResponse

    suspend fun getAutoCompleteLocationDetails(): List<AutoCompleteLocationResponse>
}