package com.romreviewer.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.romreviewer.learncompose.ui.theme.LearnComposeTheme

class Dynamic : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicListScreen()
        }
    }
}

@Composable
fun DynamicListScreen() {
    val greetingListState = remember {
        mutableStateListOf("ABC")
    }
    val newNameStateContent = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(
            greetingListState,
            newNameStateContent.value,
            {
            greetingListState.add(newNameStateContent.value)
        }, {
            newNameStateContent.value = it
        })
    }

}


@Composable
fun GreetingList(
    nameList: List<String>,
    textFieldValue: String,
    buttonClick: () -> Unit,
    newText: (text: String) -> Unit
) {

    nameList.forEach {
        Greeting(name = it)
    }

    TextField(value = textFieldValue, onValueChange = {
        newText.invoke(it)
    })
    Button(onClick = { buttonClick.invoke() }) {
        Text(text = "Add New")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = name)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LearnComposeTheme {
        DynamicListScreen()
    }
}