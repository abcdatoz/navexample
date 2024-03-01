package com.example.navexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.navexample.navigation.AppNavigation
import com.example.navexample.ui.Practice.Calculadora
import com.example.navexample.ui.Practice.Calculator
import com.example.navexample.ui.Practice.ColumnsAndRows
import com.example.navexample.ui.bnmx.MenuNoAuth
import com.example.navexample.ui.bnmx.SignIn
import com.example.navexample.ui.bnmx.Submenu
import com.example.navexample.ui.bnmx.WelcomeName
import com.example.navexample.ui.book.BookViewModel
import com.example.navexample.ui.theme.NavexampleTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navexample.data.remote.model.Data

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Rey", "testing ")


        setContent {
            NavexampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    AppNavigation()

                    //Greeting("Android")

//                    Submenu()
//                    ColumnsAndRows()
//                    Calculadora()
//                    SignIn()
//                    MenuNoAuth()

                }
            }
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

//    Log.d("Rey", "testing ")
//
//    println("AA")
//    val bookVM = viewModel(modelClass = BookViewModel::class.java)
//    println("BB")
//    val books by bookVM.books.collectAsState()
//
//    println(books)

    val bookVM = viewModel(modelClass = BookViewModel::class.java)
    val books by bookVM.books.collectAsState()


    LazyColumn( ) {
        items(books.data) { item: Data ->
            com.example.navexample.ui.book.BookCard(item = item)
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NavexampleTheme {
//        Greeting("Android")
//    }
//}


@Composable
fun BookCard(item: Data){
    Card (
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ){
        Column{
            Text(text = "ISBN: ${item.ISBN}")
            Text(text = "Year: ${item.Year}")
            Text(text = "Pages: ${item.Pages}")
            Text(text = "Publisher: ${item.Publisher}")
            Text(text = "# Villains: ${item.villains.count()}")
        }
    }
}