package com.example.scoutdraft3.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scoutdraft3.navigation.BottomNavItem
import com.example.scoutdraft3.ui.*

@Composable
fun GeneralScreen(navController: NavHostController,
                  modes: List<BottomNavItem>
){
    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "$matchHeader || Sofia's Swagalicious Endgame Screen")
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
                        icon = { Icon(item.Icon, null)},
                        label = { Text(item.name) },
                        selected = selectedItem == 3,
                        onClick = { selectedItem = index; navController.navigate(item.route) }
                    )
                }
            }
        },
        content = { padding ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(padding), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.size(10.dp))
//                Text(text = "Endgame Screen", Modifier.align(Alignment.CenterHorizontally), textAlign = TextAlign.Center, fontSize = 48.sp)
//                Spacer(modifier = Modifier.size(50.dp))
                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    Docking()
                }
                Spacer(modifier = Modifier.size(20.dp))

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    TextFieldFoul()
                }
                Spacer(modifier = Modifier.size(20.dp))

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    TextFieldBreaks()
                }
                Spacer(modifier = Modifier.size(20.dp))

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    TextFieldExtra()
                }
                Spacer(modifier = Modifier.size(50.dp))

                Box(Modifier.align(Alignment.CenterHorizontally)) {
                    TextFieldName()
                }

                Spacer(modifier = Modifier.size(20.dp))

                val context = LocalContext.current
                ExportButton(context)
        }
    })
}