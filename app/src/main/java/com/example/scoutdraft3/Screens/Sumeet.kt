package com.example.scoutdraft3.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scoutdraft3.navigation.BottomNavItem
import com.example.scoutdraft3.ui.*

@Composable
fun AutonScreen(
    navController: NavHostController,
    modes: List<BottomNavItem>
){
    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "$matchHeader || Sumeet's Auton Screen", color = lightColors().onSurface)

                },
                contentColor = lightColors().surface,
                elevation = 10.dp
            )
        },
        bottomBar = {
            var selectedItem by remember { mutableStateOf(selectedScreen) }
            BottomNavigation {
                modes.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.Icon, null)},
                        label = { Text(item.name) },
                        selected = selectedItem == 1,
                        onClick = { selectedItem = index; navController.navigate(item.route) },
                    )
                }
            }
        },
        content = { padding ->
            Column {
                // Text(text = "Sumeet's Auton Screen", Modifier.align(Alignment.CenterHorizontally), textAlign = TextAlign.Center, fontSize = 48.sp)

                Row(Modifier.width(600.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column(modifier = Modifier.width(225.dp)) {
                        Spacer(modifier = Modifier.size(20.dp))
                        AutonCones()
                    }

                    TextColumn()

                    Column(modifier = Modifier.width(225.dp)) {
                        Spacer(modifier = Modifier.size(20.dp))
                        AutonCubes()
                    }
                }

                Box(
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                ) {
                    Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                            MobilityBox()
                            Spacer(modifier = Modifier.size(8.dp))
                            AutonDocking()
                        }
                    }
                }
            }
        }
    )
}
