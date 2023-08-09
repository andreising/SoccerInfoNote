package com.andreisingeleytsev.soccernotebet.ui.screens.teams_screen

sealed class TeamsScreenEvent {
    data class OnTeamChose(val id: Int):TeamsScreenEvent()
}
