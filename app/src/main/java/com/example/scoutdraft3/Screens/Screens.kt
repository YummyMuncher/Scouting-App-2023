package com.example.scoutdraft3.Screens

sealed class Screens(val route: String) {
    object Start: Screens("start_screen")
    object Auton: Screens("auton_screen")
    object Teleop: Screens("teleop_screen")
    object Endgame: Screens("endgame_screen")
    object export: Screens("export_screen")
    object QRScreen: Screens("qr_screen")
}