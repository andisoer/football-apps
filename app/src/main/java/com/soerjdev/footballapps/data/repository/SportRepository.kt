package com.soerjdev.footballapps.data.repository

import com.soerjdev.footballapps.data.NetworkApiService

class SportRepository {

    suspend fun allSport() = NetworkApiService.executeTask().allSport()

}