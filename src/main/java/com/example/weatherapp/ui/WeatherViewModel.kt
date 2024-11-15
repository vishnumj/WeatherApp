package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.AutoCompleteLocationResponse
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    private val _autoCompleteLocationState = MutableStateFlow<List<AutoCompleteLocationResponse>>(emptyList())
    val weatherState: StateFlow<WeatherResponse?> get() = _weatherState
    val autoCompleteLocationState: StateFlow<List<AutoCompleteLocationResponse>> get() = _autoCompleteLocationState

    fun fetchWeather(location: String) {
        viewModelScope.launch {
            val response = repository.getWeather(location)
            _weatherState.value = response
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getAutoCompleteLocationDetails() {
        viewModelScope.launch {
            val response = repository.getAutoCompleteLocationDetails()
            _autoCompleteLocationState.value = response
        }
    }
}