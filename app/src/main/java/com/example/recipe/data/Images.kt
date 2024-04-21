package com.example.recipe.data

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipe.R
import com.example.recipe.ui.theme.RecipeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatScreen()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(color = Color.White) {
            content()
        }
    }
}


data class Cat(val name: String, val painter: Int)

class CatRepository {
    private val cats: List<Cat> = listOf(
        Cat("Caramelized\nFrench Onion Dip", R.drawable.meat_loaf),
        Cat("Orange", R.drawable.meat_loaf),
    )

    fun loadCat(): Cat {
        val randomIndex = (Math.random()*cats.size).toInt()
        return cats[randomIndex]
    }
}

@Composable
fun CatScreen() {
    val catViewModel: CatScreenViewModel = viewModel()
    val cats by catViewModel.cats


    Column {

        Text(text = "Select your favorite color!",
            modifier = Modifier
                .padding(28.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(cats) { cat ->
                CatCard(cat)
            }
        }
    }
}

@Composable
fun CatCard(cat: Cat) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { Toast.makeText(context, "You’ve selected color!!", Toast.LENGTH_SHORT).show() },
        shape = RoundedCornerShape(12.dp),
    ) {


        Row (

            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){


            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = cat.name,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

class CatScreenViewModel : ViewModel() {
    private val catRepository = CatRepository()
    val cats by lazy { mutableStateOf(generateCats()) }

    private fun generateCats(): List<Cat> {
        val catList = mutableListOf<Cat>()
        repeat(100) { // Change 10 to the number of cats you want to generate
            catList.add(catRepository.loadCat())
        }
        return catList
    }
}

@Preview(showBackground = true)
@Composable
fun CardRecipePreview() {
    RecipeTheme {
        CatScreen()
    }
}

