package com.andreisingeleytsev.soccernotebet.data.retrofit.repository

import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.CurrentLeague
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Player
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Players

interface PlayersRepository {
    suspend fun setPlayers(id: Int)
    suspend fun getPlayers(): List<Player>
}