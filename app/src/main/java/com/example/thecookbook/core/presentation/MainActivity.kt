package com.example.thecookbook.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.thecookbook.category_list.presentation.CategoryScreen
import com.example.thecookbook.core.presentation.ui.theme.TheCookBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheCookBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CategoryScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

