package com.example.scoutdraft3.ui

import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import kotlinx.coroutines.*
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.FileWriter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

var exportString:String = "There happens to be an inkly dinkly issue!! Tell hector ASAP!!!"

//Start Variables
var teamNumber: String = ""

var matchNumber: String = ""

var matchType: String = "Qualifier"

var selectedScreen: Int = 0

var matchID: String =  "$teamNumber : $matchNumber"

var matchHeader: String = "Team $teamNumber | Match $matchNumber "

//Auton Vars
var lowConeScoreAuton: Int = 0

var lowCubeScoreAuton: Int = 0

var midConeScoreAuton: Int = 0

var midCubeScoreAuton: Int = 0

var highConeScoreAuton: Int = 0

var highCubeScoreAuton: Int = 0

var mobility: Boolean = false

var balanceAuton: String = "Nothing"

//Teleop Vars
var lowConeScoreTeleop: Int = 0

var lowCubeScoreTeleop: Int = 0

var midConeScoreTeleop: Int = 0

var midCubeScoreTeleop: Int = 0

var highConeScoreTeleop: Int = 0

var highCubeScoreTeleop: Int = 0

var intakeShelfCubes:Int = 0

var intakeFloorCubes: Int = 0

var intakeFloorCones: Int = 0

var intakeShelfCones: Int = 0

var DefenceTimer1: String = "00:00:000"

var DefendedTimer1: String = "00:00:00"

//EndGame
var docking: String = "Nothing"

//General
var defenceNotes: String = ""

var breakNotes: String = ""

var foulNotes: String = "0"

var extraNotes: String = ""

var scoutName: String = ""



@Composable
fun AutonCones(){
    var low by rememberSaveable{ mutableStateOf(lowConeScoreAuton) }
    var mid by rememberSaveable{ mutableStateOf(midConeScoreAuton) }
    var high by rememberSaveable{ mutableStateOf(highConeScoreAuton) }

    Column {
        Text(text = "Cones", Modifier.align(Alignment.CenterHorizontally), fontSize = 24.sp)
        Spacer(Modifier.size(24.dp))

        ButtonRow({high++; highConeScoreAuton = high}, high, {if(high>0){high--; highConeScoreAuton = high}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({ mid++; midConeScoreAuton = mid}, mid,{if(mid>0){mid--; midConeScoreAuton = mid}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({low++; lowConeScoreAuton = low}, low, {if(low>0){low--; lowConeScoreAuton = low}})
        Spacer(Modifier.size(24.dp))
    }
}

@Composable
fun AutonCubes(){
    var low by rememberSaveable{ mutableStateOf(lowCubeScoreAuton) }
    var mid by rememberSaveable{ mutableStateOf(midCubeScoreAuton) }
    var high by rememberSaveable{ mutableStateOf(highCubeScoreAuton) }

    Column(Modifier.width(225.dp)) {
        Text(text = "Cubes", Modifier.align(Alignment.CenterHorizontally), fontSize = 24.sp)
        Spacer(Modifier.size(24.dp))

        ButtonRow({high++; highCubeScoreAuton = high}, high, {if(high>0){high--; highCubeScoreAuton = high}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({ mid++; midCubeScoreAuton = mid }, mid,{if(mid>0){mid--; midCubeScoreAuton = mid}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({low++; lowCubeScoreAuton =  low}, low, {if(low>0){low--; lowCubeScoreAuton =  low}})
        Spacer(Modifier.size(24.dp))

    }
}

@Composable
fun TeleopCones(){
    var low by rememberSaveable{ mutableStateOf(lowConeScoreTeleop) }
    var mid by rememberSaveable{ mutableStateOf(midConeScoreTeleop) }
    var high by rememberSaveable{ mutableStateOf(highConeScoreTeleop) }

    Column {
        Text(text = "Cones", Modifier.align(Alignment.CenterHorizontally), fontSize = 24.sp)
        Spacer(Modifier.size(24.dp))

        ButtonRow({high++; highConeScoreTeleop = high}, high, {if(high>0){high--; highConeScoreTeleop = high}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({ mid++; midConeScoreTeleop = mid}, mid,{if(mid>0){mid--; midConeScoreTeleop = mid}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({low++; lowConeScoreTeleop = low}, low, {if(low>0){low--; lowConeScoreTeleop = low}})
        Spacer(Modifier.size(24.dp))
    }
}

@Composable
fun TeleopCubes(){
    var low by rememberSaveable{ mutableStateOf(lowCubeScoreTeleop) }
    var mid by rememberSaveable{ mutableStateOf(midCubeScoreTeleop) }
    var high by rememberSaveable{ mutableStateOf(highCubeScoreTeleop) }

    Column(Modifier.width(225.dp)) {
        Text(text = "Cubes", Modifier.align(Alignment.CenterHorizontally), fontSize = 24.sp)
        Spacer(Modifier.size(24.dp))

        ButtonRow({high++; highCubeScoreTeleop = high}, high, {if(high>0){high--; highCubeScoreTeleop = high}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({ mid++; midCubeScoreTeleop = mid }, mid,{if(mid>0){mid--; midCubeScoreTeleop = mid}})
        Spacer(Modifier.size(24.dp))

        ButtonRow({low++; lowCubeScoreTeleop =  low}, low, {if(low>0){low--; lowCubeScoreTeleop =  low}})
        Spacer(Modifier.size(24.dp))
    }
}

@Composable
fun IntakeCubeTeleop(){
    var cubefloor by rememberSaveable{ mutableStateOf(intakeFloorCubes) }
    var cubeShelf by rememberSaveable{ mutableStateOf(intakeShelfCubes) }
    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Cube Intakes", Modifier.padding(16.dp), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(25.dp))
        ButtonRow(upper = { cubeShelf++; intakeShelfCubes = cubeShelf }, num = cubeShelf, downer = {if(cubeShelf>0){cubeShelf--; intakeShelfCubes = cubeShelf} })
        Spacer(modifier = Modifier.size(25.dp))
        ButtonRow(upper = {cubefloor++; intakeFloorCubes = cubefloor }, num = cubefloor, downer = {if(cubefloor>0){cubefloor--; intakeFloorCubes = cubefloor} })
    }

}

@Composable
fun IntakeConeTeleop(){
    var conefloor by rememberSaveable{ mutableStateOf(intakeFloorCones) }
    var coneshelf by rememberSaveable{ mutableStateOf(intakeShelfCones) }
    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Cone Intakes", Modifier.padding(16.dp), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(25.dp))
        ButtonRow(upper = { coneshelf++; intakeShelfCones = coneshelf }, num = coneshelf, downer = {if(coneshelf>0){coneshelf--; intakeShelfCones = coneshelf} })
        Spacer(modifier = Modifier.size(25.dp))
        ButtonRow(upper = {conefloor++; intakeFloorCones = conefloor }, num = conefloor, downer = {if(conefloor>0){conefloor--; intakeFloorCones = conefloor} })
    }
}

@Composable
fun MatchTypeSelect(){
    val radioOptions = listOf("Qualifications", "Playoffs")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    Row {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val context = LocalContext.current
                RadioButton(
                    selected = (text == selectedOption),
                    modifier = Modifier
                        .padding(all = Dp(value = 4F))
                        .align(Alignment.CenterVertically),
                    onClick = {
                        onOptionSelected(text)
                        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                        matchType = text
                    }
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun Docking(){
    val radioOptions = listOf("Nothing", "Park", "Dock", "Engage")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    Row {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text); docking = text }
                    )
                    .padding(horizontal = 8.dp)
            ) {
                val context = LocalContext.current
                RadioButton(
                    selected = (text == selectedOption),
                    modifier = Modifier
                        .padding(all = Dp(value = 4F))
                        .align(Alignment.CenterVertically),
                    onClick = {
                        onOptionSelected(text)
                        docking = text
                        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                    }
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun AutonDocking(){
    val radioOptions = listOf("Nothing", "Dock", "Engage")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    Row {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text); balanceAuton = text }
                    )
                    .padding(horizontal = 8.dp)
            ) {
                val context = LocalContext.current
                RadioButton(
                    selected = (text == selectedOption),
                    modifier = Modifier
                        .padding(all = Dp(value = 4F))
                        .align(Alignment.CenterVertically),
                    onClick = {
                        onOptionSelected(text)
                        balanceAuton = text
                        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                    }
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun MobilityBox(){
    var mobility2 by rememberSaveable{ mutableStateOf(mobility) }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
        Checkbox(checked = mobility2, onCheckedChange = { it -> mobility2 = it; mobility = it })
        Spacer(modifier = Modifier.size(3.dp))
        Text(text = "Mobility Bonus")
    }
}

@Composable
fun TextFieldMatch(){
    var text by rememberSaveable{ mutableStateOf(matchNumber) }
    Column {
        TextField(
            value = text,
            onValueChange = { it ->
                text = it
                matchNumber = text
                matchID = "$teamNumber : $matchNumber"
                matchHeader = "Team $teamNumber | Match $matchNumber"
            },
            Modifier
                .height(60.dp)
                .width(300.dp),
            label = { Text(text = "Match Number") },
            placeholder = { Text(text = "Enter Match number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
    }
}

@Composable
fun TextFieldTeam(){
    var text by rememberSaveable{ mutableStateOf(teamNumber) }
        TextField(
            value = text,
            onValueChange = { it ->
                text = it
                teamNumber = text
                matchID = "$teamNumber : $matchNumber"
                matchHeader = "Team $teamNumber | Match $matchNumber"

                            },
            Modifier
                .height(60.dp)
                .width(300.dp),
            label = { Text(text = "Team Number") },
            placeholder = { Text(text = "Enter team number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
}

@Composable
fun TextFieldBreaks(){
    var text by rememberSaveable{ mutableStateOf(breakNotes) }
    TextField(
        value = text,
        onValueChange = { it ->
            text = it
            breakNotes = text },
        Modifier
            .width(300.dp),
        label = { Text(text = "Did they break? If so, how?") },
        placeholder = { Text(text = "Explain what broke?") },
    )
}

@Composable
fun TextFieldFoul() {
    var text by rememberSaveable { mutableStateOf(foulNotes) }
    TextField(
        value = text,
        onValueChange = {
            text = it
            foulNotes = text
        },
        Modifier
            .width(300.dp),
        label = { Text(text = "Alliance penalty points") },
        placeholder = { Text(text = "Get from score screen") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun TextFieldExtra(){
    var text by rememberSaveable{ mutableStateOf(extraNotes) }
    TextField(
        value = text,
        onValueChange = {
            text = it
            extraNotes = text },
        Modifier
            .width(300.dp),
        label = { Text(text = "Extra notes") },
        placeholder = { Text(text = "for anything misc.") },
    )
}
@Composable
fun TextFieldName(){
    var text by rememberSaveable{ mutableStateOf(scoutName) }
    TextField(
        value = text,
        onValueChange = {
            text = it
            scoutName = text },
        Modifier
            .width(300.dp),
        label = { Text(text = "Scouter name: ") },
        placeholder = { Text(text = "You must put your name!") },
    )
}

private fun writeToFile(message: String) {
    val file = BufferedWriter(
        FileWriter(
            "/storage/emulated/0/${Environment.DIRECTORY_DOWNLOADS}/$teamNumber-$matchNumber-$matchType.txt", false
        )
    )
    file.write("$message\n")
    file.close()
}

@Composable
fun StopWatchDisplay(
    formattedTime: String,
    onStart: () -> Unit,
    onPause: () -> Unit,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier.width(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedTime, textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            Button(
                onClick = onStart,
                modifier = modifier
                    .width(140.dp)
                    .height(50.dp),
                interactionSource = interactionSource
            ) {
                when (isPressed){
                    true -> onStart()
                    else -> onPause()
                }
                Text(text = "Hold to time")
            }
        }
    }
}

@Composable
fun ExportButton(context: Context){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var popupControl by remember { mutableStateOf(false) }
        Button(onClick = {
            if(defenceNotes.isEmpty())
                defenceNotes = "N/A"
            if(breakNotes.isEmpty())
                breakNotes = "N/A"
            if(foulNotes.isEmpty())
                foulNotes = "N/A"
            if(extraNotes.isEmpty())
                extraNotes = "N/A"

            exportString =
                "$teamNumber~ $matchNumber~ $matchType~ $lowConeScoreAuton~ $midConeScoreAuton~ $highConeScoreAuton~ $lowCubeScoreAuton~ $midCubeScoreAuton~ $highCubeScoreAuton~ $lowConeScoreTeleop~ $midConeScoreTeleop~ $highConeScoreTeleop~ $lowCubeScoreTeleop~ $midCubeScoreTeleop~ $highCubeScoreTeleop~ $intakeFloorCones~ $intakeShelfCones~ $intakeFloorCubes~ $intakeShelfCubes~ $docking~ $mobility~ $balanceAuton~ $breakNotes~ $foulNotes~ $extraNotes~ $scoutName~ $DefendedTimer1~ $DefenceTimer1"
            try {
                if(!scoutName.isEmpty()){
                    writeToFile(exportString)
                    popupControl = true
                } else{
                    Toast.makeText(context, "You didnt enter your name!!!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: FileNotFoundException) {
                Toast.makeText(context, "YOU DIDN'T ALLOW SYSTEM PRIVILEGES", Toast.LENGTH_SHORT)
                    .show()
            }
            Log.d("Export", "Exported")
        }) {
            Text(text = "Export")
        }
        if (popupControl){
            Popup(alignment = Alignment.TopCenter) {
                Image(bitmap = QRStuff(exportString), contentDescription = null)
            }
        }
        exportString =
            "$teamNumber~ $matchNumber~ $matchType~ $lowConeScoreAuton~ $midConeScoreAuton~ $highConeScoreAuton~ $lowCubeScoreAuton~ $midCubeScoreAuton~ $highCubeScoreAuton~ $lowConeScoreTeleop~ $midConeScoreTeleop~ $highConeScoreTeleop~ $lowCubeScoreTeleop~ $midCubeScoreTeleop~ $highCubeScoreTeleop~ $intakeFloorCones~ $intakeShelfCones~ $intakeFloorCubes~ $intakeShelfCubes~ $docking~ $mobility~ $balanceAuton~ $breakNotes~ $foulNotes~ $extraNotes~ $scoutName~ $DefendedTimer1~ $DefenceTimer1"
    }
}

class DefenceStopWatch {
    var Timer by mutableStateOf(DefenceTimer1)

    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var isActive = false

    private var timeMillis = 0L
    private var lastTimeStamp = 0L

    fun start() {
        if(isActive) return
        coroutineScope.launch {
            lastTimeStamp = System.currentTimeMillis()
            this@DefenceStopWatch.isActive=true
            while(this@DefenceStopWatch.isActive){
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimeStamp
                lastTimeStamp = System.currentTimeMillis()
                Timer = formatTime(timeMillis)
            }

        }
    }

    fun pause() {
        this@DefenceStopWatch.isActive = false
        DefenceTimer1 = Timer
    }

    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis),
            ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern(
            "mm:ss:SSS",
            Locale.getDefault()
        )


        return localDateTime.format(formatter)
    }
}

class DefendedStopWatch {
    var timer by mutableStateOf(DefendedTimer1)

    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var isActive = false

    private var timeMillis = 0L
    private var lastTimeStamp = 0L

    fun start() {
        if(isActive) return
        coroutineScope.launch {
            lastTimeStamp = System.currentTimeMillis()
            this@DefendedStopWatch.isActive=true
            while(this@DefendedStopWatch.isActive){
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimeStamp
                lastTimeStamp = System.currentTimeMillis()
                timer = formatTime(timeMillis)
            }

        }
    }

    fun pause() {
        this@DefendedStopWatch.isActive = false
        DefendedTimer1 = timer
    }

    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis),
            ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern("mm:ss:SSS",
            Locale.getDefault()
        )
        return localDateTime.format(formatter)
    }
}
//
//fun resetVariables(){
//    exportString = "what?"
//    selectedScreen = 0
//    lowConeScoreAuton = 0
//    lowCubeScoreAuton = 0
//    midConeScoreAuton = 0
//    midCubeScoreAuton = 0
//    highConeScoreAuton = 0
//    highCubeScoreAuton = 0
//    mobility = false
//    balanceAuton = ""
//    lowConeScoreTeleop = 0
//    lowCubeScoreTeleop = 0
//    midConeScoreTeleop = 0
//    midCubeScoreTeleop = 0
//    highConeScoreTeleop = 0
//    highCubeScoreTeleop = 0
//    intakeShelfCubes = 0
//    intakeFloorCubes = 0
//    intakeFloorCones = 0
//    intakeShelfCones = 0
//    DefenceTimer1 = "00:00:000"
//    DefendedTimer1 = "00:00:00"
//    docking = ""
//    defenceNotes = ""
//    breakNotes = ""
//    foulNotes = ""
//}

/*
teamNumber,matchNumber,matchType,lowConeScoreAuton,midConeScoreAuton,highConeScoreAuton,lowCubeScoreAuton,midCubeScoreAuton,highCubeScoreAuton,lowConeScoreTeleop,midConeScoreTeleop,highConeScoreTeleop,lowCubeScoreTeleop,midCubeScoreTeleop,highCubeScoreTeleop,intakeShelfCubes,intakeFloorCubes,intakeFloorCones,intakeShelfCones,docking,mobility,balanceAuton,defenceNotes,breakNotes,foulNotes,DefendedTimer1,DefenceTimer1
                        */



