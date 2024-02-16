package com.example.navexample.ui.bnmx.About

import android.annotation.SuppressLint
import android.provider.SyncStateContract.Columns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun OperacionesDisponiblesPreview(){

    val navController = rememberNavController()
    OperacionesDisponibles(navController)

}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OperacionesDisponibles(navController: NavController){

    Scaffold(){

        Column(){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)

            ) {


                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.Close, "", Modifier.size(20.dp))
                }

                Text("Operaciones Disponibles")
            }


            Spacer(modifier = Modifier.fillMaxWidth())

            Text("Lorem Ipsum and other things.....")


        }



    }
}


