package com.example.thecookbook.meal_detail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun MealDetailsScreen(
    mealId: String,
    modifier: Modifier = Modifier,
    mealDetailsViewModel: MealDetailsViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        mealDetailsViewModel.loadMealDetails(mealId)
    }

    val mealDetailsState by mealDetailsViewModel.mealDetailState.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Meal Details",
            modifier = Modifier.padding(start = 12.dp),
            style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 28.sp)
        )

        when {
            mealDetailsState.isMealDetailsLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            mealDetailsState.errorMsg.isNotEmpty() -> {
                Text(
                    text = mealDetailsState.errorMsg,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            mealDetailsState.mealDetails.isNotEmpty() -> {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(mealDetailsState.mealDetails) { mealDetail ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = mealDetail.strMeal)
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Absolute.SpaceBetween
                        ) {
                            Text(text = mealDetail.strCategory)
                            Text(text = mealDetail.strArea)
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        AsyncImage(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(mealDetail.strMealThumb)
                                .size(Size.ORIGINAL)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = mealDetail.strInstructions)
                    }
                }
            }
        }
    }
}