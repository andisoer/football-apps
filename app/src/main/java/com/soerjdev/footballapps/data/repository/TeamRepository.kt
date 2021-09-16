package com.soerjdev.footballapps.data.repository

import com.soerjdev.footballapps.data.NetworkApiService

class TeamRepository {

    suspend fun searchTeam(
        teamName: String
    ) = NetworkApiService.executeTask().searchTeam(teamName = teamName)

}