package com.soerjdev.footballapps.data

import com.soerjdev.footballapps.data.model.Country
import com.soerjdev.footballapps.data.model.League
import com.soerjdev.footballapps.data.model.Sport
import com.soerjdev.footballapps.data.model.Team
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoints {

    @GET("searchteams.php")
    suspend fun searchTeam(
        @Query("t") teamName: String
    ): Response<Team>

    @GET("search_all_leagues.php")
    suspend fun searchLeague(
        @Query("c") country: String,
        @Query("s") sport: String
    ): Response<League>

    @GET("all_countries.php")
    suspend fun allCountry(): Response<Country>

    @GET("all_sports.php")
    suspend fun allSport(): Response<Sport>

    @GET("search_all_teams.php")
    suspend fun searchTeamByLeague(
        @Query("l") league: String
    ): Response<Team>


}