package com.example.scoutdraft3.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SettingsInputAntenna
import androidx.compose.material.icons.filled.Start
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.scoutdraft3.Screens.*

@Composable
fun NavGraph (navController: NavHostController){
    val bottomNavItems =
        listOf<BottomNavItem>(
            BottomNavItem("Start", Screens.Start.route, Icon = Icons.Filled.Start),
            BottomNavItem( "Auton", Screens.Auton.route, Icon = Icons.Filled.SettingsInputAntenna),
            BottomNavItem("Teleop", Screens.Teleop.route, Icon = Icons.Filled.Gamepad),
            BottomNavItem("EndGame", Screens.Endgame.route, Icon = Icons.Filled.Settings),)


    NavHost(navController = navController, startDestination = Screens.Start.route){

        composable(route = Screens.Start.route){
            StartScreen(navController, bottomNavItems)
        }
        composable(route = Screens.Auton.route){
            AutonScreen(navController, bottomNavItems)
        }

        composable(route = Screens.Teleop.route){
            TeleopScreen(navController = navController, bottomNavItems)
        }

        composable(route = Screens.Endgame.route){
            GeneralScreen(navController = navController, bottomNavItems)
        }

        composable(route = Screens.QRScreen.route){

        }
    }
}

