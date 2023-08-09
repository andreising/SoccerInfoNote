package com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation

import android.util.Log
import com.andreisingeleytsev.soccernotebet.data.retrofit.api.PlayersAPI
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Player
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.PlayersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class PlayersRepositoryImpl(
    retrofit: Retrofit
): PlayersRepository {
    private val playersAPI: PlayersAPI = retrofit.create(PlayersAPI::class.java)
    private var players = mutableListOf<Player>()
    init {
        CoroutineScope(Dispatchers.IO).launch {
            playersAPI.getPlayers(33).response.forEach {
                players.add(it.player!!)
            }
        }
    }
    override suspend fun setPlayers(id: Int) {
        players.clear()
        playersAPI.getPlayers(id).response.forEach {
            players.add(it.player!!)
        }
    }

    override suspend fun getPlayers(): List<Player> {
        return players
    }
}