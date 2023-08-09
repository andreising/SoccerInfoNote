package com.andreisingeleytsev.soccernotebet.data.retrofit.repository

import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.CurrentLeague
import org.json.JSONArray

interface TeamRepository {
    suspend fun setLeague(league: String)
    suspend fun getLeague(): CurrentLeague
}