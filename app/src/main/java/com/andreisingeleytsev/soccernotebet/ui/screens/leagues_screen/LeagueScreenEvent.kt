package com.andreisingeleytsev.soccernotebet.ui.screens.leagues_screen

sealed class LeagueScreenEvent {
    data class OnLeagueChose(val name: String): LeagueScreenEvent()
}
