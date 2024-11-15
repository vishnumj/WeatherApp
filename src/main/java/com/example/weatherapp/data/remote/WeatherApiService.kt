package com.example.weatherapp.data.remote

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.model.AutoCompleteLocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse

    @GET("locations/v1/cities/autocomplete")
    suspend fun getAutoCompleteLocationDetails(
        @Query("q") location: String,
        @Query("apikey") apiKey: String
    ): List<AutoCompleteLocationResponse>
}

// For reference.
//https://developer.accuweather.com/accuweather-locations-api/apis/get/locations/v1/cities/autocomplete
//https://github.com/jissajaison1/EmployeeDetails/tree/master
//https://www.youtube.com/watch?v=8JJ101D3knE