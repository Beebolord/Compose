package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Android")
                        cardsOnTheTable()
                        Row {
                            Spacer(modifier = Modifier.size(50.dp))
                            Ball(Blue)
                            Spacer(modifier = Modifier.size(100.dp))
                            Ball(Green)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun cardsOnTheTable() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
        modifier = paddingModifier
    ){
        Text(
            text = "Simple cad with elevation",
            modifier = paddingModifier
        )
    }
}

@Composable
fun Ball(colorForBall: Color) {
    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .size(50.dp),

        onDraw = {
            val size = 50.dp.toPx()
            drawCircle(
                color = colorForBall,
                radius = size / 2f,
            )
        },
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}