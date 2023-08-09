package com.andreisingeleytsev.soccernotebet.ui.screens.leagues_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.BUNDESLIGA
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.EDERVISE
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.LA_LIGA
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.LIGUE1
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.PREMIER_LEAGUE
import com.andreisingeleytsev.soccernotebet.data.retrofit.repository.implementation.SERIE_A
import com.andreisingeleytsev.soccernotebet.ui.theme.MainColor
import com.andreisingeleytsev.soccernotebet.ui.theme.Secondary
import com.andreisingeleytsev.soccernotebet.ui.utils.Fonts
import com.andreisingeleytsev.soccernotebet.ui.utils.Routes
import com.andreisingeleytsev.soccernotebet.ui.utils.UIEvents

@Composable
fun LeaguesScreen(navController: NavHostController, viewModel: LeagueScreenViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{
            when(it) {
                is UIEvents.OnNavigate -> {
                    navController.navigate(it.route)
                }
                else -> {}
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize().background(MainColor), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "LEAGUE", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Premier League", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White
            ), modifier = Modifier.clickable {
                viewModel.onEvent(LeagueScreenEvent.OnLeagueChose(PREMIER_LEAGUE))
            }
        )
        Divider(thickness = 5.dp, color = Secondary)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Ligue 1", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White
            ), modifier = Modifier.clickable {
                viewModel.onEvent(LeagueScreenEvent.OnLeagueChose(LIGUE1))
            }
        )
        Divider(thickness = 5.dp, color = Secondary)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Bundesliga", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White
            ), modifier = Modifier.clickable {
                viewModel.onEvent(LeagueScreenEvent.OnLeagueChose(BUNDESLIGA))
            }
        )
        Divider(thickness = 5.dp, color = Secondary)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "La Liga", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White
            ), modifier = Modifier.clickable {
                viewModel.onEvent(LeagueScreenEvent.OnLeagueChose(LA_LIGA))
            }
        )
        Divider(thickness = 5.dp, color = Secondary)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Serie A", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White
            ), modifier = Modifier.clickable {
                viewModel.onEvent(LeagueScreenEvent.OnLeagueChose(SERIE_A))
            }
        )
        Divider(thickness = 5.dp, color = Secondary)
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Eredivisie", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White
            ), modifier = Modifier.clickable {
                viewModel.onEvent(LeagueScreenEvent.OnLeagueChose(EDERVISE))
            }
        )
    }


}