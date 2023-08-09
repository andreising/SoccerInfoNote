package com.andreisingeleytsev.soccernotebet.ui.utils

sealed class UIEvents(){
    data class OnNavigate(val route: String): UIEvents()
}
