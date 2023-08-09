package com.andreisingeleytsev.soccernotebet.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andreisingeleytsev.soccernotebet.R
import com.andreisingeleytsev.soccernotebet.ui.theme.Primary
import com.andreisingeleytsev.soccernotebet.ui.theme.Secondary
import com.andreisingeleytsev.soccernotebet.ui.utils.Fonts
import com.andreisingeleytsev.soccernotebet.ui.utils.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerMenu(menuList: List<String>, selecredItem: MutableState<String>, drawerState: DrawerState, navController: NavController) {
    Body(menuList, selecredItem, drawerState, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(menuList: List<String>, selectedItem: MutableState<String>, drawerState: DrawerState, navController: NavController) {
    val scope = rememberCoroutineScope()
    ModalDrawerSheet(
        drawerContainerColor = Primary
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.drawer_bg),
                contentDescription = "drawer_bg",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(20.dp))
                menuList.forEach { item ->
                    NavigationDrawerItem(label = {
                        Text(
                            text = item, style = TextStyle(
                                fontFamily = Fonts.font,
                                fontSize = 13.sp
                            )
                        )
                    }, selected = item == selectedItem.value, onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem.value = item
                        when (menuList.indexOf(item)) {
                            0 -> {
                                navController.navigate(Routes.LEAGUES_SCREEN)
                            }
                            1 -> {
                                navController.navigate(Routes.TEAMS_SCREEN)
                            }
                            2 -> {
                                navController.navigate(Routes.PLAYERS_SCREEN)
                            }
                            3 -> {
                                navController.navigate(Routes.NOTE_SCREEN)
                            }
                        }

                    }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Transparent,
                            unselectedContainerColor = Color.Transparent,
                            selectedTextColor = Secondary,
                            unselectedTextColor = Color.White
                        ))
                }
            }
        }

    }
}

