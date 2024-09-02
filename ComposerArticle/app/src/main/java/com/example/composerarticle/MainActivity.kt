package com.example.composerarticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composerarticle.ui.theme.ComposerArticleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposerArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    articleDisplay(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun articleDisplay(modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        articleImage(
            modifier = Modifier
                .padding(18.dp)
                .align(Alignment.End)
        )
        articleText(
            title = "Jetpack Compose tutorial",
            subtitle = """
                Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.
            """.trimIndent(),
            content = """
                In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.
            """.trimIndent()
        )
    }
}

@Composable
fun articleText(title: String, subtitle: String, content: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .border(BorderStroke(0.dp, Color.Black))
        )
        Text(
            text = subtitle,
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(8.dp)
                .border(BorderStroke(0.dp, Color.Black))
        )
        Text(
            text = content,
            modifier = Modifier
                .padding(8.dp)
                .border(BorderStroke(0.dp, Color.Black))
        )
    }
}

@Composable
fun articleImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .padding(0.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposerArticleTheme {
        articleDisplay()
    }
}