package com.andreisingeleytsev.soccernotebet.ui.screens.leagues_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.TeamRepository
import com.andreisingeleytsev.soccernotebet.ui.utils.Routes
import com.andreisingeleytsev.soccernotebet.ui.utils.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueScreenViewModel @Inject constructor(
    private val teamRepository: TeamRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: LeagueScreenEvent){
        when(event) {
            is LeagueScreenEvent.OnLeagueChose -> {
                viewModelScope.launch {
                    teamRepository.setLeague(event.name)
                }
                sendUIEvent(UIEvents.OnNavigate(Routes.TEAMS_SCREEN))
            }

            else -> {}
        }

    }

    private fun sendUIEvent(event: UIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}