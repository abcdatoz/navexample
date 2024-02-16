package com.example.navexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.navexample.navigation.AppNavigation
import com.example.navexample.ui.Practice.Calculadora
import com.example.navexample.ui.Practice.Calculator
import com.example.navexample.ui.Practice.ColumnsAndRows
import com.example.navexample.ui.bnmx.MenuNoAuth
import com.example.navexample.ui.bnmx.SignIn
import com.example.navexample.ui.bnmx.Submenu
import com.example.navexample.ui.bnmx.WelcomeName
import com.example.navexample.ui.theme.NavexampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            NavexampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")

//                    Navigation()

                    AppNavigation()
//                    Submenu()
                    //ColumnsAndRows()
//                    Calculadora()
//                    SignIn()
//                    MenuNoAuth()

                }
            }
        }
    }
}




//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NavexampleTheme {
//        Greeting("Android")
//    }
//}