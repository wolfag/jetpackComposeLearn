@file:OptIn(ExperimentalMaterialApi::class)

package com.example.mycompose

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.repo.PersonRepo
import com.example.mycompose.screens.SetupNavGraph
import com.example.mycompose.ui.theme.MyComposeTheme
import com.example.mycompose.ui.theme.Shapes
import com.example.mycompose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                SetupNavGraph(navHostController = navController)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyString() {
    val sections = listOf<String>("A", "B", "C", "D", "E", "F", "G")
    LazyColumn() {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    text = "Section $section", modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(12.dp)
                )
            }
            items(10) {
                Text(
                    text = "Item $it from the section $section",
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun LazyPerson() {
    val personRepo = PersonRepo()
    val data = personRepo.getAllData()

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(items = data, key = { _, person ->
            person.id
        }) { _, person ->
            CustomItem(person = person)
        }
    }
}

@Composable
fun Indicator() {
    var value by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        MyProgress(indicatorValue = value.toInt())

        TextField(
            value = value.toString(),
            onValueChange = {
                value = if (it.isNotEmpty()) it.toInt() else 0

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }


}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
//        LazyString()

        Indicator()
    }
}