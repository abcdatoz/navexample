package com.example.navexample.ui.Practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow

@Preview
@Composable
fun Calculadora() {
    var result by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = result, fontSize = 48.sp, fontWeight = FontWeight.Bold)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Buttton(text = "7", onClick = { result += "7" })
            Buttton(text = "8", onClick = { result += "8" })
            Buttton(text = "9", onClick = { result += "9" })
            Buttton(text = "/", onClick = { result += "/" })
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Buttton(text = "4", onClick = { result += "4" })
            Buttton(text = "5", onClick = { result += "5" })
            Buttton(text = "6", onClick = { result += "6" })
            Buttton(text = "*", onClick = { result += "*" })
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Buttton(text = "1", onClick = { result += "1" })
            Buttton(text = "2", onClick = { result += "2" })
            Buttton(text = "3", onClick = { result += "3" })
            Buttton(text = "-", onClick = { result += "-" })
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Buttton(text = "C", onClick = { result = "0" })
            Buttton(text = "0", onClick = { result += "0" })
            Buttton(text = "=", onClick = { result = evale(result).toString() })
            Buttton(text = "+", onClick = { result += "+" })
        }
    }
}

fun evale(str: String): Int {
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

@Composable
fun Buttton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text = text, fontSize = 24.sp)
    }
}


