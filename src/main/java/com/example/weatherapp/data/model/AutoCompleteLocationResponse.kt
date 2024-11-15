package com.example.weatherapp.data.model

data class AutoCompleteLocationResponse(
    val version: Int,
    val key: String,
    val type: String,
    val rank: Int,
    val localizedName: String,
    val country: Country,
    val administrativeArea: AdministrativeArea
) {
    data class Country(val id: String, val localizedName: String)
    data class AdministrativeArea(val id: String, val localizedName: String)
}
