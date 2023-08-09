package com.andreisingeleytsev.soccernotebet.data.retrofit.api

import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Players
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PlayersAPI {
    @GET("/players?season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getPlayers(@Query("team") id: Int): Players
}