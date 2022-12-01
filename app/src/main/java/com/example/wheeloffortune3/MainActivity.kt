package com.example.wheeloffortune3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.wheeloffortune3.screens.*
import com.example.wheeloffortune3.ui.theme.LViewModel
import com.example.wheeloffortune3.ui.theme.WheelOfFortune3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WheelOfFortune3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = LViewModel()
                    Layout(viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(modifier: Modifier = Modifier) {
    WheelOfFortune3Theme {
        // Layout()
    }
}

@Composable
fun Layout(viewModel: LViewModel) {
    val state by viewModel.state2.collectAsState()
//horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Row() {
            Title()
            Column() {
                Lives()
                Balance()
            }

        }
        //Spacer(modifier = Modifier.height(30.dp))
        Wheel()
            SpinPoints()
            Category()
        Spacer(modifier = Modifier.height(30.dp))
        Spin("Spin")
        Spacer(modifier = Modifier.height(30.dp))
        Row() {
            Word(state.concealedWord)
        }
        Text(text = state.realWOrd)
        Spacer(modifier = Modifier.height(30.dp))
        Keyboard(viewModel)
    }
}