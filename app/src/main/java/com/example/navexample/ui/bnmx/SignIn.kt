package com.example.navexample.ui.bnmx

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navexample.R
import com.example.navexample.navigation.AppScreens
import java.time.format.TextStyle


@Composable
fun SignIn(navController: NavController) {
    val logo: Painter = painterResource(id = R.drawable.banamex)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Icon(Icons.Default.Refresh, "")
            }

            Button(
                onClick = {
                          navController.navigate(route = AppScreens.WelcomeMenu.route)
                }, modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Icon(Icons.Default.List, "")
            }
        }

        Spacer(modifier = Modifier.fillMaxWidth())

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Citibanamex",
                color = Color.Blue,
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 16.dp)
            )

            Image(painter = logo, contentDescription = "", modifier = Modifier.size(20.dp))

        }



        Spacer(modifier = Modifier.fillMaxWidth())
        Text(
            "Buenas tardes rey",
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.fillMaxWidth())

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 20.dp)

        ) {


            Spacer(modifier = Modifier.fillMaxWidth())

            PasswordTextField()


            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp)
            )


            Text(text = "Ingrese con huella", fontSize = 12.sp)
            Spacer(modifier = Modifier.fillMaxWidth())
            Text(text = "Olvidaste tu contraseña?", fontSize = 12.sp)

        }


        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(350.dp)
        )




        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue),
            )
            {
                Icon(Icons.Default.ArrowBack, "")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)

            ) {
                Text("Codi")
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(Icons.Default.Home, "")
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Ingrese su contraseña") },

        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = if (passwordVisibility) Icons.Filled.CheckCircle else Icons.Filled.Check,
                    contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

}

@Composable
fun OutlinedTextFieldBackground() {

}


@Preview
@Composable
fun preview_signin() {
    val navController = rememberNavController()

    SignIn(navController = navController)
}