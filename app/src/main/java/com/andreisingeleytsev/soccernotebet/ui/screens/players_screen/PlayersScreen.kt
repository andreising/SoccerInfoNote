package com.andreisingeleytsev.soccernotebet.ui.screens.players_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels.Player
import com.andreisingeleytsev.soccernotebet.ui.screens.teams_screen.TeamItem
import com.andreisingeleytsev.soccernotebet.ui.screens.teams_screen.TeamsScreenEvent
import com.andreisingeleytsev.soccernotebet.ui.theme.MainColor
import com.andreisingeleytsev.soccernotebet.ui.theme.Primary
import com.andreisingeleytsev.soccernotebet.ui.utils.Fonts

@Composable
fun PlayersScreen(viewModel: PlayerScreenViewModel = hiltViewModel()) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MainColor), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Players", style = TextStyle(
                fontFamily = Fonts.font,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
        Row(modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Spacer(modifier = Modifier.width(40.dp))
            Text(
                text = "Name", style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            )
            Text(
                text = "Age", style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            )
            Text(
                text = "Height", style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            )
            Text(
                text = "Weight", style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            )
        }
        LazyColumn(modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()) {
            items(viewModel.list){
                PlayerItem(player = it)
            }
        }
    }
}

@Composable
fun PlayerItem(player: Player) {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
        containerColor = Color.LightGray
    )) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = player.photo,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Text(
                text = player.name!!, style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ), maxLines = 2, modifier = Modifier.width(50.dp)
            )
            Text(
                text = player.age.toString(), style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ), maxLines = 2
            )
            Text(
                text = player.height.toString(), style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ), maxLines = 2
            )
            Text(
                text = player.weight.toString(), style = TextStyle(
                    fontFamily = Fonts.font,
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ), maxLines = 2
            )
        }
    }
}