package com.andreisingeleytsev.soccernotebet.ui.screens.players_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Player
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.PlayersRepository
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerScreenViewModel @Inject constructor(
    val rep: PlayersRepository
): ViewModel() {
    var list = emptyList<Player>()
    init {
        viewModelScope.launch {
            list = rep.getPlayers()
        }
    }
}