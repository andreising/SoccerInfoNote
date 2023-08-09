package com.andreisingeleytsev.soccernotebet.data.retrofit.api

import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.CurrentLeague
import dagger.Provides
import org.json.JSONArray
import retrofit2.http.GET
import retrofit2.http.Headers

interface TeamAPI {




    @GET("/teams?league=39&season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getPL(): CurrentLeague

    @GET("/teams?league=61&season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getFranceLeague(): CurrentLeague
    @GET("/teams?league=78&season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getGermanyLeague(): CurrentLeague
    @GET("/teams?league=135&season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getItalyLeague(): CurrentLeague
    @GET("/teams?league=140&season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getSpainLeague(): CurrentLeague
    @GET("/teams?league=88&season=2023")
    @Headers(
        "x-rapidapi-key: 67f673fc064034e0185c7f1ee50a77b9",
        "x-rapidapi-host: v3.football.api-sports.io"
    )
    suspend fun getNetherlandsLeague(): CurrentLeague




}