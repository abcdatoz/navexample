package com.example.navexample.ui.Practice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ColumnsAndRows(){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text("ABC", color = Color.Yellow)
        Spacer(modifier = Modifier.fillMaxWidth())
        Text("PQR", color = Color.Magenta)
        Spacer(modifier = Modifier.fillMaxWidth())
        Text("Arigato to", color = Color.White, style = TextStyle(fontSize = 20.sp))

        val coloredStyle  = TextStyle(color = Color.Yellow)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Hinata" , style = coloredStyle)
            Text("Tsunade", style = coloredStyle)
            Text("Hiruka", style = coloredStyle)
        }

        Spacer(modifier = Modifier.fillMaxWidth())
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Icon(
                Icons.Rounded.Home,
                "Home",
                modifier = Modifier.size(30.dp),
                tint= Color.DarkGray
            )
            Icon(
                Icons.Rounded.Menu,
                "Menu",
                modifier = Modifier.size(30.dp),
                tint= Color.DarkGray
            )
            Icon(
                Icons.Rounded.AccountCircle,
                "Menu",
                modifier = Modifier.size(30.dp),
                tint= Color.DarkGray
            )
            Icon(
                Icons.Rounded.Call,
                "Menu",
                modifier = Modifier.size(30.dp),
                tint= Color.DarkGray
            )
            Icon(
                Icons.Rounded.DateRange,
                "Menu",
                modifier = Modifier.size(30.dp),
                tint= Color.DarkGray
            )
            Icon(
                Icons.Rounded.LocationOn,
                "Menu",
                modifier = Modifier.size(30.dp),
                tint= Color.DarkGray
            )




        }
        Spacer(modifier = Modifier.fillMaxWidth())
        Box(modifier = Modifier.background(color = Color.Yellow)){
            Text("verdeamarella", color = Color.Blue)
        }
        Spacer(modifier = Modifier.fillMaxWidth())

        val lista = listOf("Apple", "Orange", "Peach", "Mango", "Pineaple","Watermelon", "Avocado")
        LazyRow(
            //contentPadding = PaddingValues()
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        )
        {
            items(
                items = lista,
                key = { itemAsId -> itemAsId}
            ){it ->
                Text(it)
            }
//            item {
//                Text("one", color = Color.Blue, style = TextStyle(fontSize = 20.sp) , modifier = Modifier.padding(horizontal = 5.dp))
//                Text("two", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("three", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("four", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("five", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("six", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("seven", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("eight", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("nine", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("ten", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("eleven", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//                Text("twelve", color = Color.Blue, style = TextStyle(fontSize = 20.sp))
//            }


        }

        Text("XYZ", color = Color.Yellow)


    }
}
