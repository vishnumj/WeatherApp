package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.AutoCompleteLocationResponse
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.remote.WeatherApiService
import com.example.weatherapp.domain.repository.WeatherRepository
import retrofit2.HttpException

class WeatherRepositoryImpl(private val apiService: WeatherApiService) : WeatherRepository {
    override suspend fun getWeather(location: String): WeatherResponse {
        return apiService.getWeather(location, "GsBxsVbXezsYZskQgOIzxv1T6p2VBT2j")
    }

    override suspend fun getAutoCompleteLocationDetails(): List<AutoCompleteLocationResponse> {
        return try {
            apiService.getAutoCompleteLocationDetails("New ", "GsBxsVbXezsYZskQgOIzxv1T6p2VBT2j")
        } catch (e: HttpException) {
            // Handle HTTP exception
            emptyList()
        } catch (e: Exception) {
            // Handle other exceptions
            emptyList()
        }    }
}

