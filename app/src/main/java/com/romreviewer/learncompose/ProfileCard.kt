package com.romreviewer.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romreviewer.learncompose.ui.theme.LearnComposeTheme
import com.romreviewer.learncompose.ui.theme.lightGreen

class ProfileCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.LightGray
        ) {
            ProfileCardView()
        }
    }

}

@Composable
fun AppBar() {
    TopAppBar(navigationIcon = {
        Icon(
            Icons.Default.Home,
            contentDescription = "Home Icon",
            modifier = Modifier.padding(12.dp)
        )
    },
        title = { Text(text = "Messaging Application Users") })

}

@Composable
fun ProfileCardView() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.Top),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Composable
fun ProfilePicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colors.lightGreen),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.cool_profile_picture),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "John Doe", style = MaterialTheme.typography.h5)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = "Active Now", style = MaterialTheme.typography.body2)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LearnComposeTheme {
        Screen()
    }
}