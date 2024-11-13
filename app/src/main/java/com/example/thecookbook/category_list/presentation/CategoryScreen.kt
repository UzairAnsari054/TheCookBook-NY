package com.example.thecookbook.category_list.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.thecookbook.category_list.domain.model.Category

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    categoryViewModel: CategoryViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        categoryViewModel.loadCategories()
    }

    val categoriesState by categoryViewModel.categoriesState.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Categories",
            modifier = Modifier.padding(start = 12.dp),
            style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 28.sp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(categoriesState.categories) { category ->
                CategoryItem(category = category)
            }
        }
    }
}

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .width(130.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            model = ImageRequest.Builder(LocalContext.current)
                .data(category.strCategoryThumb)
                .size(Size.ORIGINAL)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(28.dp))

        Column {
            Text(
                text = category.strCategory,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryScreenPreview(modifier: Modifier = Modifier) {
    CategoryScreen()
}