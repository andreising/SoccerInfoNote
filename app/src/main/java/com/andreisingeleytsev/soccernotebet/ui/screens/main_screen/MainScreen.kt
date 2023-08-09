package com.andreisingeleytsev.soccernotebet.ui.screens.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.soccernotebet.ui.menu.DrawerMenu
import com.andreisingeleytsev.soccernotebet.ui.navigation.MainNavigationGraph
import com.andreisingeleytsev.soccernotebet.ui.utils.MenuList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val menuList = MenuList.menuList
    val selectedItem = remember { mutableStateOf(menuList[0]) }
    ModalNavigationDrawer(
        drawerContent = {
            DrawerMenu(menuList = menuList, selecredItem = selectedItem, drawerState = drawerState, navController)
        },
        drawerState = drawerState,
    ) {
        MainNavigationGraph(navController = navController)
    }
}