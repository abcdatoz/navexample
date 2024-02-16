package com.example.navexample.ui.Practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import kotlin.math.pow


sealed class Numbers(
    var nombre: String,
    var icon: ImageVector,
    var color: Color
) {
    object one : Numbers("1", Icons.Default.AccountBox, Color.DarkGray)
    object two : Numbers("2", Icons.Default.Build, Color.DarkGray)
    object three : Numbers("3", Icons.Default.Call, Color.DarkGray)
    object four : Numbers("4", Icons.Default.DateRange, Color.DarkGray)
    object five : Numbers("5", Icons.Default.Home, Color.Blue)
    object six : Numbers("6", Icons.Default.Face, Color.Blue)
    object seven : Numbers("7", Icons.Default.Email, Color.Blue)
    object eight : Numbers("8", Icons.Default.AccountBox, Color.Blue)
    object nine : Numbers("9", Icons.Default.AccountBox, Color.Blue)
    object zero : Numbers("0", Icons.Default.AccountBox, Color.Blue)
    object suma : Numbers("+", Icons.Default.Add, Color.Blue)
    object resta : Numbers("-", Icons.Default.ArrowDropDown, Color.Blue)
    object multiplicar : Numbers("*", Icons.Default.Clear, Color.Blue)
    object dividir : Numbers("/", Icons.Default.Check, Color.Blue)
    object punto : Numbers(".", Icons.Default.Check, Color.Blue)
    object igual : Numbers("=", Icons.Default.Check, Color.Blue)

}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Calculator() {

    var result by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = result, fontSize = 48.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.fillMaxWidth())

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Btn(Numbers.one, onClick = {result += "1"})
            Btn(Numbers.two, onClick = {result += "2"})
            Btn(Numbers.three, onClick = {result += "3"})
            Btn(Numbers.suma, onClick = {result += "+"})
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Btn(Numbers.four, onClick = {result += "4"})
            Btn(Numbers.five,onClick = {result += "5"})
            Btn(Numbers.six,onClick = {result += "6"})
            Btn(Numbers.resta,onClick = {result += "-"})
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Btn(Numbers.seven,onClick = {result += "7"})
            Btn(Numbers.eight,onClick = {result += "8"})
            Btn(Numbers.nine,onClick = {result += "9"})
            Btn(Numbers.multiplicar,onClick = {result += "*"})
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Btn(Numbers.punto,onClick = {result = ""})
            Btn(Numbers.zero,onClick = {result += "0"})
            Btn(Numbers.igual,onClick = {result = eval(result).toString()})
            Btn(Numbers.dividir,onClick = {result += "/"})

        }
    }
}

@Composable
fun Btn(item: Numbers, onClick: () -> Unit ){




    Button(onClick =  onClick , modifier = Modifier.padding(8.dp)) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(item.icon, contentDescription = "")

            Text(item.nombre, fontSize = 24.sp)
        }

    }
}


fun eval(str: String): Int {
    return object : Any() {
        var pos = -1
        var ch = 0

        fun nextChar() {
            ch = if (++pos < str.length) str[pos].toInt() else -1
        }

        fun eat(charToEat: Int): Boolean {
            while (ch == ' '.toInt()) nextChar()
            if (ch == charToEat) {
                nextChar()
                return true
            }
            return false
        }

        fun parse(): Int {
            nextChar()
            val x = parseExpression()
            if (pos < str.length) throw RuntimeException("Carácter inesperado: " + ch.toChar())
            return x
        }

        fun parseExpression(): Int {
            var x = parseTerm()
            while (true) {
                if (eat('+'.toInt())) x += parseTerm()
                else if (eat('-'.toInt())) x -= parseTerm()
                else return x
            }
        }

        fun parseTerm(): Int {
            var x = parseFactor()
            while (true) {
                if (eat('*'.toInt())) x *= parseFactor()
                else if (eat('/'.toInt())) x /= parseFactor()
                else return x
            }
        }

        fun parseFactor(): Int {
            if (eat('+'.toInt())) return parseFactor()
            if (eat('-'.toInt())) return -parseFactor()
            var x: Int
            val startPos = pos
            if (eat('('.toInt())) {
                x = parseExpression()
                eat(')'.toInt())
            } else if (ch in '0'.toInt()..'9'.toInt()) {
                while (ch in '0'.toInt()..'9'.toInt()) nextChar()
                x = str.substring(startPos, pos).toInt()
            } else {
                throw RuntimeException("Carácter inesperado: " + ch.toChar())
            }
            if (eat('^'.toInt())) x = x.toDouble().pow(parseFactor().toDouble()).toInt()
            return x
        }
    }.parse()
}

