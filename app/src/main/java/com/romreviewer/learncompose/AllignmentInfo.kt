package com.romreviewer.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romreviewer.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        horizontalLine(color = Color.Blue)
        horizontalLine(color = Color.Red)
        horizontalLine(color = Color.Black)

    }
}

@Composable
fun horizontalLine(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(100.dp)
            .width(350.dp)
    ) {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current
    LearnComposeTheme {
        MainScreen()
    }
}