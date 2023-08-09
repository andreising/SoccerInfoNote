package com.andreisingeleytsev.soccernotebet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andreisingeleytsev.soccernotebet.ui.screens.leagues_screen.LeaguesScreen
import com.andreisingeleytsev.soccernotebet.ui.screens.notes_screen.MyNotesScreen
import com.andreisingeleytsev.soccernotebet.ui.screens.players_screen.PlayersScreen
import com.andreisingeleytsev.soccernotebet.ui.screens.teams_screen.TeamsScreen
import com.andreisingeleytsev.soccernotebet.ui.utils.Routes

@Composable
fun MainNavigationGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.LEAGUES_SCREEN) {

        composable(Routes.LEAGUES_SCREEN){
            LeaguesScreen(navController)
        }
        composable(Routes.TEAMS_SCREEN){
            TeamsScreen(navController)
        }
        composable(Routes.PLAYERS_SCREEN){
            PlayersScreen()
        }
        composable(Routes.NOTE_SCREEN){
            MyNotesScreen()
        }
    }
}
