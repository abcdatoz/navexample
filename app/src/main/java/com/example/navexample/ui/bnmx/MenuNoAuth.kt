package com.example.navexample.ui.bnmx

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class Page(val title: String, val content: String) {
    HOME("home", "Show only icon"),
    SEARCH("search", "show icon with label"),
    SETTINGS("Settings", "show icon/show the label only whem selected")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable

fun MenuNoAuth() {


    Column{
        TopAppBar(

            title = { Text("im a topappbar") }

        )
    }



//    Column(Modifier.padding(16.dp)){
//        val texState = remember { mutableStateOf(TextFieldValue()) }
//
//        TextField(value = texState.value, onValueChange = {texState.value =  it})
//        Text("the textfield has this text:" + texState.value.text)
//    }

//    //surface
//    Surface(
//        modifier = Modifier.padding(8.dp),
//        border = BorderStroke(2.dp, Color.Red),
//        contentColor = Color.Blue,
//        shape = CircleShape
//    ){
//        Text("arigato", modifier = Modifier.padding(8.dp))
//    }



//        //switch
//        val checkedState = remember{ mutableStateOf(true) }
//        Switch(checkedState.value, onCheckedChange = {  checkedState.value =it })

//    //snackbar
//    Column {
//        val (abc, setAbc) = remember { mutableStateOf(false) }
//
//        Button(onClick = {
//            setAbc(!abc)
//        }) {
//            if (abc) {
//                Text("hide snack")
//            } else {
//                Text("show snack")
//            }
//        }
//
//        if (abc) {
//            Snackbar(
//                action = {
//                    Button(onClick = { /*TODO*/ }) {
//                        Text("MyAction")
//                    }
//                },
//                modifier = Modifier.padding(8.dp)
//            ){
//                Text("This is rio!")
//            }
//        }
//    }


//    //Slider
//    var sliderPossition by remember { mutableStateOf(0f) }
//    Text(sliderPossition.toString())
//    Slider(value = sliderPossition, onValueChange = { sliderPossition =it } )


//    //radiobutton
//    val radioOptions  = listOf("A","B","C")
//    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
//
//    Column{
//        radioOptions.forEach { text ->
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .selectable(
//                        selected = text == selectedOption,
//                        onClick = { onOptionSelected(text) })
//                    .padding(horizontal = 16.dp)
//            ){
//                RadioButton(selected = text == selectedOption, onClick = { onOptionSelected (text) })
//                Text(text, style = MaterialTheme.typography.bodySmall)
//            }
//        }
//    }


//    //Navigation Rail
//    var selectedItem by remember {
//        mutableStateOf(0)
//    }
//    val pages = Page.values()
//    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
//
//    Row{
//      NavigationRail {
//          pages.forEachIndexed() {  index, item ->
//
//              when(item){
//
//                  Page.HOME -> {
//                      NavigationRailItem(
//                          selected = selectedItem == index,
//                          onClick = { selectedItem = index },
//                          icon = { Icon(icons[index],"") })
//                  }
//                  Page.SEARCH ->{
//                      NavigationRailItem(
//                          label = { Text(item.title)},
//                          selected = selectedItem == index,
//                          onClick = { selectedItem = index },
//                          icon = { Icon(icons[index],"") })
//                  }
//
//                  Page.SETTINGS -> {
//                      NavigationRailItem(
//                          label = { Text(item.title)},
//                          selected = selectedItem == index,
//                          onClick = { selectedItem = index },
//                          icon = { Icon(icons[index],"") },
//                          alwaysShowLabel = false
//                      )
//                  }
//
//              }
//          }
//      }
//    }

//    ModalNavigationDrawer(
//        drawerContent = {
//            ModalDrawerSheet {
//                Text("Drawer title", modifier = Modifier.padding(16.dp))
//                Divider()
//                NavigationDrawerItem(
//                    label = { Text(text = "Drawer Item") },
//                    selected = false,
//                    onClick = { /*TODO*/ }
//                )
//                // ...other drawer items
//            }
//        }
//    ) {
//        // Screen content
//    }


//    //Linear ProgressIndicator
//
//    var progress by remember {
//        mutableStateOf(0.1f)
//    }
//
//    val animatedProgress = animateFloatAsState(targetValue = progress, animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec).value
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally){
//        Spacer(Modifier.height(30.dp))
//        Text("Linear progress indicator")
//        LinearProgressIndicator()
//        Spacer(Modifier.height(30.dp))
//        Text("LinearProgressIndicator with set by buttons")
//        Spacer(Modifier.height(30.dp))
//        LinearProgressIndicator(progress = animatedProgress)
//
//        Spacer(Modifier.height(30.dp))
//        OutlinedButton(onClick = {  if (progress < 1f) progress += 0.1f }) {
//            Text("Increase")
//        }
//        OutlinedButton(onClick = {  if (progress > 0f) progress -= 0.1f  }) {
//            Text("Decrease")
//        }
//    }


//    ExtendedFloatingActionButton(
//        text = { Text("ejemplo de Ext F") },
//        icon = { Icon(Icons.Default.Share,"") },
//        onClick = { /*TODO*/ },
//        elevation = FloatingActionButtonDefaults.elevation(8.dp)
//    )


//    FloatingActionButton(onClick = { /*TODO*/ }) {
//        Text("FloatingActionButton")
//    }


    //checked
//    val checkedState = remember { mutableStateOf(true) }
//    Checkbox(checked = checkedState.value, onCheckedChange =  { checkedState.value = it })


//    //DropDownMenu
//    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("A", "B", "C", "D", "E", "G")
//    val disabledValue = "B"
//    var selectedIndex by remember { mutableStateOf(0) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.TopStart)
//    ) {
//        Text(
//            items[selectedIndex], modifier = Modifier
//                .fillMaxWidth()
//                .clickable(onClick = { expanded = true })
//                .background(Color.Green)
//        )
//
//        DropdownMenu(expanded = expanded
//            , onDismissRequest = {  expanded = false }
//            , modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.Yellow)
//            ) {
//                items.forEachIndexed {index,s ->
//
//
//                    val disabledText = if (s == disabledValue){
//                            " (disabled)"
//                        }else{
//                            ""
//                        }
//
//                    DropdownMenuItem(
//                        text = { Text(s + disabledText) },
//                        onClick = {
//                            selectedIndex = index
//                            expanded = false
//                        }
//                    )
//
//                }
//        }
//    }


//
//    //Circular progress Indicator
//    var progress by remember { mutableStateOf(0.1f) }
//    val animatedProgress = animateFloatAsState(
//        targetValue = progress,
//        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
//    ).value
//
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Spacer(Modifier.height(30.dp))
//        Text("CircularProgressive with undefined progress")
//        CircularProgressIndicator()
//        Spacer(Modifier.height(30.dp))
//        Text("CircularProgressive with progress sety by button")
//        CircularProgressIndicator(progress = animatedProgress)
//        Spacer(Modifier.height(30.dp))
//        OutlinedButton(
//            onClick = {
//                if (progress < 1f) progress += 0.1f
//
//            }) {
//                Text("Increase")
//        }
//
//        OutlinedButton(onClick = {  if (progress > 0f) progress -= 0.1f  }) {
//            Text("Decrease")
//        }
//
//
//    }


//    //CARD
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(15.dp)
//            .clickable { }
//
//    ) {
//        Column(modifier = Modifier.padding(15.dp)) {
//            Text(buildAnnotatedString {
//                append("Welcome to")
//                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFFC226DD))){
//                    append("Jetpack compose playground")
//                }
//            })
//
//            Text(buildAnnotatedString {
//                append("Now you are in the ")
//                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)){
//                    append("Card")
//                }
//                append(" section")
//            })
//        }
//    }


    // Alert Example

//    MaterialTheme{
//        Column(verticalArrangement = Arrangement.Top){
//            val openDialog = remember { mutableStateOf(false) }
//            Button (onClick = {openDialog.value = true}){
//                Text("Pushame..")
//            }
//
//            if(openDialog.value){
//                AlertDialog(
//                    onDismissRequest = { openDialog.value = false },
//                    title = { Text(text = "Titulo")},
//                    text = { Text("esto es el contenido")},
//                    confirmButton = {
//
//                        Button(onClick = {openDialog.value = false}) {
//                            Text(text = "Confirmando")
//                        }
//                    },
//                    dismissButton = {
//                        Button(onClick = { openDialog.value = false }) {
//                            Text(text = "Lets go")
//                        }
//                    }
//                )
//
//
//            }
//        }
//    }
}



