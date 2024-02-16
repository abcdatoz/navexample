package com.example.navexample.ui.bnmx

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navexample.navigation.AppScreens
import com.example.navexample.navigation.BottomNavigation


sealed class Opciones(
    var nombre: String,
    var icon: ImageVector
) {
    object opcionA : Opciones("Sucursal y Cajero", Icons.Default.LocationOn)
    object opcionB : Opciones("Afore Mobil", Icons.Default.ThumbUp)
    object opcionC : Opciones("Acerca de ", Icons.Filled.CheckCircle)
}

val listaOpciones = listOf(Opciones.opcionA, Opciones.opcionB, Opciones.opcionC)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeMenu(navController: NavController) {


    Scaffold(
        bottomBar = {
            BottomNavigation()
        }
    ) {
        BodyContentWelcomeMenu(navController)
    }

}



@Composable
fun BodyContentWelcomeMenu(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp).fillMaxWidth()

        ) {


            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.Close, "", Modifier.size(20.dp))
            }

            Text("Menu")
        }

        Spacer(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.fillMaxWidth())

        val context = LocalContext.current

        LazyColumn(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ) {
            items(items = listaOpciones, itemContent = { opc ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column (){
                        Row( verticalAlignment = Alignment.CenterVertically ){
                            Icon(opc.icon, "",)

                            Text(opc.nombre, modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    Toast
                                        .makeText(
                                            context, "${opc.nombre}", Toast.LENGTH_SHORT
                                        )
                                        .show()
                                })
                        }


                    }

                    Button(onClick = { navController.navigate(AppScreens.AcercaDe.route) } ,colors = ButtonDefaults.buttonColors(Color.White)) {
                        Text(">", color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }




            })

        }
    }

}


@Preview
@Composable
fun WelcomemenuPreview() {
    val navController = rememberNavController()

    WelcomeMenu(navController = navController)
}


