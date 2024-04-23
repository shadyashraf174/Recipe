package com.example.recipe.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.recipe.RecipeCard
import com.example.recipe.ui.theme.RecipeTheme

@Composable
fun RecipeHomeScreen(names: List<String> = List(1000) { "$it" }) {
    val navController = rememberNavController()
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Recipes",
            modifier = Modifier.padding(start = 16.dp, top = 46.dp),
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    top = 11.dp,
                    end = 8.dp,
                    bottom = 6.dp),
            value = text,
            onValueChange = { text = it },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = { Text("Search") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        )

        LazyColumn {
            items(items = names) {
                RecipeCard(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeHomeScreenPreview() {
    RecipeTheme {
        RecipeHomeScreen()
    }
}
