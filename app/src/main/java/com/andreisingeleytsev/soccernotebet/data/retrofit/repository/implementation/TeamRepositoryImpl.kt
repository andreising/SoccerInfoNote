package com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation

import com.andreisingeleytsev.soccernotebet.data.retrofit.api.TeamAPI
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.CurrentLeague
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.TeamRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import retrofit2.Retrofit

class TeamRepositoryImpl(
    retrofit: Retrofit
): TeamRepository {
    val teamAPI: TeamAPI = retrofit.create(TeamAPI::class.java)
    private var currentLeague = CurrentLeague()
    init {
        CoroutineScope(Dispatchers.IO).launch {
            currentLeague = teamAPI.getPL()
        }
    }
        
    override suspend fun setLeague(league: String) {
        currentLeague = when (league) {
            PREMIER_LEAGUE -> {
                teamAPI.getPL()
            }
            BUNDESLIGA -> {
                teamAPI.getGermanyLeague()
            }
            LIGUE1 -> {
                teamAPI.getFranceLeague()
            }
            SERIE_A -> {
                teamAPI.getItalyLeague()
            }
            LA_LIGA -> {
                teamAPI.getSpainLeague()
            }
            EDERVISE -> {
                teamAPI.getNetherlandsLeague()
            }
            else -> {
                teamAPI.getItalyLeague()
            }
        }
    }
    override suspend fun getLeague(): CurrentLeague = currentLeague

}

const val PREMIER_LEAGUE = "pl"
const val LIGUE1 = "l1"
const val BUNDESLIGA = "BS"
const val SERIE_A = "sa"
const val LA_LIGA = "la_liga"
const val EDERVISE = "ed"
