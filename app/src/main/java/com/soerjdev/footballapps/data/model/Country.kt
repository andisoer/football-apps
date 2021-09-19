package com.soerjdev.footballapps.data.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("countries")
    val countries: List<Country>?
) {
    data class Country(
        @SerializedName("name_en")
        val nameEn: String?
    )
}