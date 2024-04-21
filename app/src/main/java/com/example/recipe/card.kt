package com.example.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipe.ui.theme.RecipeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardRecipe() {
    Card(
        modifier = Modifier
            .width(500.dp)
            .height(160.dp)
            .padding(start = 16.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(0),
        onClick = { /*TODO*/ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 6.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Meat Loaf"
                )
                Text(
                    modifier = Modifier
                        .padding(bottom = 33.dp),
                    fontSize = 13.sp,
                    color = Color.Gray,
                    text = "Yummy home made meat loaf,\n great for left lovers."
                )
                Text(
                    modifier = Modifier
                        .padding(bottom = 1.dp),
                    text = "01.05.2018"
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 30.dp, topStart = 30.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.meat_loaf),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardRecipePreview() {
    RecipeTheme {
        CardRecipe()
    }
}

