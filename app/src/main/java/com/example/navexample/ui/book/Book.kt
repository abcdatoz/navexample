package com.example.navexample.ui.book

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.navexample.data.remote.model.Data


@Composable
fun BooksScreen (navController: NavController) {


    val vm : BookViewModel = hiltViewModel()
    val books by vm.books.collectAsState()

    LazyColumn( ) {
        items(books.data) { item: Data ->
            BookCard(item = item)
        }
    }

}

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