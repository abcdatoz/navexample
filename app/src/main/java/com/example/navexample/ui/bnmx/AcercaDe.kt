package com.example.navexample.ui.bnmx

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Border
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.navexample.R
import com.example.navexample.navigation.AppScreens
import com.example.navexample.navigation.BottomNavigation


sealed class OpcionesAbout(
    var nombre: String,
    var icon: ImageVector,
    var ruta: String
) {
    object opcA : OpcionesAbout("Operaciones Disponibles", Icons.Filled.ThumbUp, AppScreens.OperacionesDisponibles.route)
    object opcB : OpcionesAbout("FAQ", Icons.Filled.Star, AppScreens.Faq.route)
    object opcC : OpcionesAbout("Terminos y Condiciones", Icons.Filled.Notifications,AppScreens.TerminosYCondiciones.route)
    object opcD : OpcionesAbout("Aviso de Provacidad", Icons.Filled.Send, AppScreens.Books.route)
}


var lista = listOf(OpcionesAbout.opcA, OpcionesAbout.opcB, OpcionesAbout.opcC, OpcionesAbout.opcD)

@Preview
@Composable
fun OpcionesAboutPreview() {
    val navController = rememberNavController()
    AcercaDe(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcercaDe(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigation()
        }
    ) {
        AcercaDeContent(navController)
    }
}


@Composable
fun AcercaDeContent(navController: NavController ) {

    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)

        ) {


            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.Close, "", Modifier.size(20.dp))
            }

            Text("Acerca de")
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {

            items(items = lista, itemContent = { opc ->
                Renglon(opc, navController)
            })

        }

    }
}


//.border(border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.navy))),

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Renglon(item: OpcionesAbout, navController: NavController ) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(item.icon, "")
                Text(item.nombre, modifier = Modifier.padding(start = 16.dp))
            }
        }
        Button(
            onClick = {
                        navController.navigate(item.ruta)

                      },
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(">", color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 30.sp)
        }

    }
}

