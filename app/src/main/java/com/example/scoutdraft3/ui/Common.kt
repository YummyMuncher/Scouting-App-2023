package com.example.scoutdraft3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonRow (upper: () -> Unit, num: Int , downer: () -> Unit){
    val buttonSize: Dp = 70.dp
    Column(
        Modifier
            .height(80.dp)
            .width(225.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround, ) {

        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = downer,
                Modifier
                    .width(buttonSize)
                    .height(buttonSize),
            ) { Text(text = "-", fontSize = 36.sp, textAlign = TextAlign.Center) }

            Text(text = num.toString(),
                Modifier
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )

            Button(onClick =  upper,
                Modifier
                    .width(buttonSize)
                    .height(buttonSize),
            ) { Text(text = "+", fontSize = 36.sp, textAlign = TextAlign.Center) }
        }
    }
}

@Composable
fun TextColumn(){
    Column (verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.height(425.dp)) {
        Text(text = "High")
        Text(text = "Mid")
        Text(text = "Low")
    }
}

@Composable
fun IntakeText(){
    Column (verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.height(425.dp), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier)
        Text(text = "Substation", textAlign = TextAlign.Center)
        Text(text = "Floor", textAlign = TextAlign.Center)
    }
}


