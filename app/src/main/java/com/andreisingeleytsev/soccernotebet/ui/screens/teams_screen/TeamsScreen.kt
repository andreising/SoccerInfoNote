package com.andreisingeleytsev.soccernotebet.ui.screens.teams_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Team
import com.andreisingeleytsev.soccernotebet.ui.screens.leagues_screen.LeagueScreenEvent
import com.andreisingeleytsev.soccernotebet.ui.theme.MainColor
import com.andreisingeleytsev.soccernotebet.ui.theme.Primary
import com.andreisingeleytsev.soccernotebet.ui.utils.Fonts
import com.andreisingeleytsev.soccernotebet.ui.utils.UIEvents

@Composable
fun TeamsScreen(
    navController: NavHostController,
    viewModel: TeamsScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
            when (it) {
                is UIEvents.OnNavigate -> {
                    navController.navigate(it.route)
                }

                else -> {}
            }
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MainColor), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "LEAGUE", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
        LazyColumn(modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()) {
            items(viewModel.list.value){
                TeamItem(team = it)
            }
        }
    }
}

@Composable
fun TeamItem(team: Team, viewModel: TeamsScreenViewModel = hiltViewModel()) {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
            containerColor = Primary
        )) {
        Row(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                viewModel.onEvent(TeamsScreenEvent.OnTeamChose(team.id!!))
            }) {
            AsyncImage(model = team.logo, contentDescription = null, modifier = Modifier.size(35.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = team.name.toString(), style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            ))
        }
    }
}