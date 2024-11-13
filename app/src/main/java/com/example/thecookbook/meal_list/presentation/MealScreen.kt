package com.example.thecookbook.meal_list.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.thecookbook.meal_list.domain.model.Meal

@Composable
fun MealScreen(
    category: String,
    onMealClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    mealListViewModel: MealListViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        mealListViewModel.loadMealList(category)
    }

    val mealListState by mealListViewModel.mealList.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Meals",
            modifier = Modifier.padding(start = 12.dp),
            style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 28.sp)
        )

        when {
            mealListState.isMealsLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            mealListState.errorMsg.isNotEmpty() -> {
                Text(
                    text = mealListState.errorMsg,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            mealListState.mealList.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(mealListState.mealList) { meal ->
                        MealItem(
                            meal = meal,
                            onMealClicked = { onMealClicked(it) })
                    }
                }
            }
        }
    }
}

@Composable
fun MealItem(
    modifier: Modifier = Modifier,
    meal: Meal,
    onMealClicked: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onMealClicked(meal.idMeal) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .height(130.dp)
                .width(130.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            model = ImageRequest.Builder(LocalContext.current)
                .data(meal.strMealThumb)
                .size(Size.ORIGINAL)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(28.dp))

        Column {
            Text(
                text = meal.strMeal,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealScreenPreview(modifier: Modifier = Modifier) {
    MealState()
}