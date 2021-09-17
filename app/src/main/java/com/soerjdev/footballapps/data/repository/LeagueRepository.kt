package com.soerjdev.footballapps.data.repository

import com.soerjdev.footballapps.data.NetworkApiService

class LeagueRepository {

    suspend fun  searchLeague(
        country: String,
        sport: String
    ) = NetworkApiService.executeTask().searchLeague(
        country = country,
        sport = sport
    )

}