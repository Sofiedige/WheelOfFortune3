package com.example.wheeloffortune3.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center

import androidx.compose.ui.Alignment.Companion.CenterHorizontally

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.wheeloffortune3.Layout
import com.example.wheeloffortune3.R
import com.example.wheeloffortune3.data.GameData
import com.example.wheeloffortune3.ui.theme.LViewModel

val gamedata: GameData = GameData()

@SuppressLint("SuspiciousIndentation")
@Composable
fun Title() {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFFA587DB),
                Color(0xFFBA68C8),
                Color(0xFFEE6262),
                Color(0xFFFFB74D),
                Color(0xFFE2D66A),
                Color(0xFFA5DA69),
                Color(0xFF3F69EB),
                Color(0xFF3FD1E4)
            )
        )
    }
    val borderWidth = 4.dp
    Text(
        text = "Wheel of fortune",
        fontSize = 40.sp, modifier = Modifier.border(BorderStroke(borderWidth, rainbowColorsBrush))
    )

}

@Composable
fun Lives() {
    Box {
        Image(
            painterResource(id = R.drawable.heart), contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
        )
        Text("5")
    }
}

@Composable
fun Balance() {
    Box {
        Image(
            painterResource(id = R.drawable.money), contentDescription = null,
            modifier = Modifier
                .height(40.dp)
                .width(30.dp)
        )
    }
}

@Composable
fun Wheel() {
    Column(horizontalAlignment = CenterHorizontally) {
        Image(
            painterResource(id = R.drawable.lykkehjul2), contentDescription = null,
            modifier = Modifier
                .height(350.dp)
                .width(350.dp)
        )
    }
}

@Composable
fun Spin(Text: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = CenterHorizontally) {
        Button(
            onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .size(height = 50.dp, width = 100.dp),
            shape = RoundedCornerShape(30.dp)

        ) {
            Text(
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
                color = Color.Black,
                text = Text
            )
        }
    }
}

@Composable
fun Category() {
    Text(
        text = "Category:" + gamedata.randomCategory(),
        fontSize = 15.sp,
    )
}

@Composable
fun SpinPoints() {
    Text(text = "Points: " + gamedata.spinData(), fontSize = 15.sp)
}

@Composable
fun Word(string: String) {
    Text(text = string)

}

@Composable
fun Keyboard(viewModel: LViewModel) {
    Column(
        horizontalAlignment = CenterHorizontally,
        //verticalArrangement = Arrangement.Bottom
    ) {
        Row() {
            LetterButton("Q", viewModel = viewModel)
            LetterButton("W", viewModel = viewModel)
            LetterButton("E", viewModel = viewModel)
            LetterButton("R", viewModel = viewModel)
            LetterButton("T", viewModel = viewModel)
            LetterButton("Y", viewModel = viewModel)
            LetterButton("U", viewModel = viewModel)
            LetterButton("I", viewModel = viewModel)
            LetterButton("O", viewModel = viewModel)
            LetterButton("P", viewModel = viewModel)
        }
        Row() {
            LetterButton("A", viewModel = viewModel)
            LetterButton("S", viewModel = viewModel)
            LetterButton("D", viewModel = viewModel)
            LetterButton("F", viewModel = viewModel)
            LetterButton("G", viewModel = viewModel)
            LetterButton("H", viewModel = viewModel)
            LetterButton("J", viewModel = viewModel)
            LetterButton("K", viewModel = viewModel)
            LetterButton("L", viewModel = viewModel)
        }
        Row(horizontalArrangement = Arrangement.Center) {
            LetterButton("Z", viewModel = viewModel)
            LetterButton("X", viewModel = viewModel)
            LetterButton("C", viewModel = viewModel)
            LetterButton("V", viewModel = viewModel)
            LetterButton("B", viewModel = viewModel)
            LetterButton("N", viewModel = viewModel)
            LetterButton("M", viewModel = viewModel)
        }
    }
}

@Composable
fun LetterButton(letter: String, modifier: Modifier = Modifier, viewModel: LViewModel) {
    Button(
        onClick = {
            viewModel.addGuess(letter[0])
        },
        colors = ButtonDefaults.buttonColors(Color.Blue),
        modifier = Modifier
            .size(height = 40.dp, width = 40.dp),
        shape = RoundedCornerShape(30.dp)

    ) {
        Text(
            fontStyle = FontStyle.Normal,
            fontSize = 15.sp,
            color = Color.White,
            text = letter
        )
    }
}

@Composable
fun findWord() {

}
