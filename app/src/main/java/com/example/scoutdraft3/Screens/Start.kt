package com.example.scoutdraft3.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.scoutdraft3.navigation.BottomNavItem
import com.example.scoutdraft3.ui.*

@Composable
fun StartScreen(navController: NavHostController, modes: List<BottomNavItem>){
    val context = LocalContext.current
    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Miguel's Start Screen")
                },
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 10.dp
            )
        },
        bottomBar = {
            var selectedItem by remember { mutableStateOf(selectedScreen) }
            BottomNavigation {
                modes.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.Icon, null) },
                        label = { Text(item.name) },
                        selected = selectedItem == 0,
                        onClick = {
                            if (!matchID.trim().equals(":"))
                                {selectedItem = index; navController.navigate(item.route)}
                            else {
                                Toast.makeText(context,"Enter team and match number first", Toast.LENGTH_SHORT).show()}
                        }
                    )
                }
            }
        },
        content = { padding ->
            Spacer(modifier = Modifier.size(25.dp))
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(padding)
            )
            {

                Text(
                    text = "MORT CHARGED UP SCOUTING APP",
                    fontSize = 48.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .size(50.dp)
                )

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    TextFieldMatch()
                }

                Spacer(
                    modifier = Modifier
                        .size(25.dp)
                )

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    MatchTypeSelect()
                }

                Spacer(
                    modifier = Modifier
                        .size(25.dp)
                )

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    TextFieldTeam()
                }

                Spacer(modifier = Modifier.size(50.dp))

                Button(
                    onClick = {
                        if (!matchID.trim().equals(":"))
                            navController.navigate(Screens.Auton.route)
                        else
                            Toast.makeText(context,"Enter team and match number first", Toast.LENGTH_SHORT).show()},
                    Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Start 'er up!!!")
                }

//                Button(
//                    onClick = { resetVariables() },
//                    Modifier.align(Alignment.CenterHorizontally)
//                ){
//                    Text(text = "Reset")
//                }
        }
    })
}
