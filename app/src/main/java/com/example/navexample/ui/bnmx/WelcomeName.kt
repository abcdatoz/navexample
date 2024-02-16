package com.example.navexample.ui.bnmx

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navexample.R
import com.example.navexample.navigation.AppScreens


@Preview
@Composable
fun WelcomeName(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {
        Box() {
            Spacer(Modifier.fillMaxWidth())
        }
        Text(
            text = stringResource(id = R.string.company_name),
            color = Color.Blue,
            fontSize = 30.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            Button(
                onClick = {
                          navController.navigate(route = AppScreens.WelcomeLogo.route + "/i feeling all right!")
                          },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(
                    "Next...",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(50.dp)
                )
            }

        }


    }
}