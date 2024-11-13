package com.example.thecookbook.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.thecookbook.category_list.presentation.CategoryScreen
import com.example.thecookbook.core.presentation.ui.theme.TheCookBookTheme
import com.example.thecookbook.meal_list.presentation.MealScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheCookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.CategoryScreen
    ) {
        composable<Screen.CategoryScreen> {
            CategoryScreen(
                onCategoryClicked = { navController.navigate(Screen.MealScreen(category = it)) }
            )
        }

        composable<Screen.MealScreen> { backStackEntry ->
            val mealScreen = backStackEntry.toRoute<Screen.MealScreen>()
            MealScreen(category = mealScreen.category)
        }
    }
}

