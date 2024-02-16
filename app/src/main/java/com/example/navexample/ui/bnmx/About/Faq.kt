package com.example.navexample.ui.bnmx.About

import android.annotation.SuppressLint
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


@Composable
@Preview
fun FaqPreview(){
    val navController = rememberNavController()

    Faq(navController)
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Faq(navController: NavController){

    Scaffold() {
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

                Text("FAQ")
            }

            Spacer(modifier = Modifier.fillMaxWidth())
            Text("Question number 1")

            Spacer(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.fillMaxWidth())
            Text("Question number 1")
            Spacer(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.fillMaxWidth())
            Text("Question number 1")
            Spacer(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.fillMaxWidth())
            Text("Question number 1")

        }
    }
}