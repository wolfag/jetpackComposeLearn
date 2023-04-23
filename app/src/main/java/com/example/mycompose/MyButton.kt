package com.example.mycompose

import android.util.Log
import android.view.Surface
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.Shapes

@Composable
fun MyButton(
    text: String = "Login with Google",
    loadingText: String = "Login...",
    onPress: () -> Unit
) {
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        modifier = Modifier.clickable {
            clicked = !clicked
            onPress()
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 18.dp,
                    top = 12.dp,
                    bottom = 12.dp,
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = "logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else text)

            if (clicked) {
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    color = Color.Blue,
                    strokeWidth = 2.dp,
                )
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    MyButton(onPress = {
        Log.d("taitest","Goooooo")
    })
}