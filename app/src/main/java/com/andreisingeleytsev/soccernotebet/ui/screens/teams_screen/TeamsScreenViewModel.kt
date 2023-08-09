package com.andreisingeleytsev.soccernotebet.ui.screens.teams_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Team
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.PlayersRepository
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.TeamRepository
import com.andreisingeleytsev.soccernotebet.ui.utils.Routes
import com.andreisingeleytsev.soccernotebet.ui.utils.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsScreenViewModel @Inject constructor(
    private val teamRepository: TeamRepository,
    private val playersRepository: PlayersRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: TeamsScreenEvent){
        when(event) {
            is TeamsScreenEvent.OnTeamChose -> {
                viewModelScope.launch {
                    playersRepository.setPlayers(event.id)
                    sendUIEvent(UIEvents.OnNavigate(Routes.PLAYERS_SCREEN))
                }

            }

            else -> {}
        }

    }

    private fun sendUIEvent(event: UIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    init {
        viewModelScope.launch {
            delay(1000)
            try {
                val rList = teamRepository.getLeague()
                val thisList = mutableListOf<Team>()
                rList.response.forEach {
                    Log.d("tag", list.toString())
                    thisList.add(it.team!!)
                }
                list.value = thisList

            } catch (_: NullPointerException) {}
        }
    }
    val list = mutableStateOf(
        listOf<Team>()
    )
}