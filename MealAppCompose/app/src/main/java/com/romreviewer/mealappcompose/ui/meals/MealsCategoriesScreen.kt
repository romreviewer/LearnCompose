package com.romreviewer.mealappcompose.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.romreviewer.mealappcompose.model.response.MealResponse

@Composable
fun MealsCategoriesScreen(navigationCallback: (String) -> Unit) {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.rememberedMeals.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MealCategory(mealResponse = meal,navigationCallback)
        }
    }

}


@Composable
fun MealCategory(mealResponse: MealResponse,navigationCallback: (String) -> Unit) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                navigationCallback.invoke(mealResponse.id)
            }
    ) {
        Row(modifier = Modifier.animateContentSize()) {
            AsyncImage(
                model = mealResponse.imageUrl,
                contentDescription = mealResponse.name,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
            ) {
                Text(
                    text = mealResponse.name,
                    style = MaterialTheme.typography.h6
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = mealResponse.description,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 10 else 4
                    )
                }

            }
            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand Row Icon",
                modifier = Modifier
                    .padding(16.dp)
                    .align(if (isExpanded) Alignment.Bottom else Alignment.CenterVertically)
                    .clickable {
                        isExpanded = !isExpanded
                    },
            )
        }

    }
}