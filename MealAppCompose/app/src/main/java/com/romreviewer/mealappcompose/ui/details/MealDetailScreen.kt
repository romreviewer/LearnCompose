package com.romreviewer.mealappcompose.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.romreviewer.mealappcompose.model.response.MealResponse
import kotlin.math.min

@Composable
fun MealDetailsScreen(mealResponse: MealResponse?) {
    val scrollState = rememberLazyListState()
    val offset = min(
        1f,
        1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
    )
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))
    Scaffold(backgroundColor = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Green
                        ),
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(size = size),
                            model = mealResponse?.imageUrl,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    }
                    Text(
                        text = mealResponse?.name ?: "",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

            }
            val dummyContentList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyContentList) {
                    Text(text = it, modifier = Modifier.padding(24.dp))
                }
            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}