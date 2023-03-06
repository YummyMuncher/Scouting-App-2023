package com.example.scoutdraft3.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scoutdraft3.navigation.BottomNavItem
import com.example.scoutdraft3.ui.*


@Composable
fun TeleopScreen(
    navController: NavHostController,
    modes: List<BottomNavItem>
){
    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "$matchHeader || Sarbina's Teleop")
                },
                elevation = 10.dp
            )
        },
        bottomBar = {
            var selectedItem by remember { mutableStateOf(0) }
            BottomNavigation {
                modes.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.Icon, null) },
                        label = { Text(item.name) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index; navController.navigate(item.route) }
                    )
                }
            }
        },
        content = { padding ->
            Column {
//                Text(text = "Teleop", Modifier.align(Alignment.CenterHorizontally), textAlign = TextAlign.Center, fontSize = 48.sp)
                Row(
                    Modifier
                        .width(600.dp)
                        .height(400.dp)
                        .padding(padding)
                    , horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column(modifier = Modifier.width(225.dp)) {
                        Spacer(modifier = Modifier.size(20.dp))
                        TeleopCones()
                    }

                    TextColumn()

                    Column(modifier = Modifier.width(225.dp)) {
                        Spacer(modifier = Modifier.size(20.dp))
                        TeleopCubes()
                    }

                }

                Row (
                    Modifier
                        .fillMaxWidth()
                        .height(260.dp), horizontalArrangement = Arrangement.SpaceEvenly){

                    Column {
                        IntakeConeTeleop()
                    }

                    Column(Modifier.fillMaxHeight()) {
                        IntakeText()
                    }

                    Column {
                        IntakeCubeTeleop()
                    }

                }

                Spacer(modifier = Modifier.height(24.dp))

                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                    Column(Modifier.width(200.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text ="Defending timer", textAlign = TextAlign.Center)
                        val stopWatch = remember { DefendedStopWatch() }
                        StopWatchDisplay(
                            formattedTime = stopWatch.timer,
                            onStart = stopWatch::start,
                            onPause = stopWatch::pause,
                        ) }

                    Column(Modifier.width(200.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Defended timer", textAlign = TextAlign.Center)
                        val stopWatch = remember { DefenceStopWatch() }
                        StopWatchDisplay(
                            formattedTime = stopWatch.Timer,
                            onStart = stopWatch::start,
                            onPause = stopWatch::pause
                        )
                    }
                }
            }
        }
    )
}
