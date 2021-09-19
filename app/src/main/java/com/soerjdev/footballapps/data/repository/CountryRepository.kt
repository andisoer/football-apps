package com.soerjdev.footballapps.data.repository

import com.soerjdev.footballapps.data.NetworkApiService

class CountryRepository {

    suspend fun allCountry() = NetworkApiService.executeTask().allCountry()
}