package com.example.businesscardapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscardapplication.ui.theme.BusinessCardApplicationTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    mainView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun mainView(modifier: Modifier = Modifier){
    Column(
        Modifier
            .background(Color.Green)
            .fillMaxSize()
    ){
        viewDetails(name = "Jennifer Doe", title = "Android Developer Extraordinaire")
        viewFooter(phoneNumber = "+254(7)0987681923", name = "@AndroidDev", email = "jane.doe@android.com")
    }
}

@Composable
fun viewFooter(modifier: Modifier = Modifier, phoneNumber: String, name: String, email: String){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(15.dp)
    ){
        Row (verticalAlignment = Alignment.CenterVertically) {
            LogoIcon(Icons.Filled.Phone)
            Text(
                text = phoneNumber,
                modifier = Modifier
                    .padding(1.dp)
            )
        }
        Row (verticalAlignment = Alignment.CenterVertically) {
            LogoIcon(Icons.Filled.Person)
            Text(
                text = name,
                modifier = Modifier
                    .padding(1.dp)
            )
        }
        Row (verticalAlignment = Alignment.CenterVertically) {
            LogoIcon(Icons.Filled.Email)
            Text(
                text = email,
                modifier = Modifier
                    .padding(1.dp)
            )
        }
    }
}

@Composable
fun LogoIcon(icon: ImageVector, modifier: Modifier = Modifier){
    Image(
        imageVector = icon,
        contentDescription = null,
        modifier = modifier
            .size(16.dp)
            .padding(1.dp)
    )
}

@Composable
fun viewDetails(modifier: Modifier = Modifier, name: String, title: String){
    Column(
        modifier = modifier
//            .align(Alignment.CenterHorizontally)
    ){
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null
        )

        Text(
            text = name,
            fontWeight = FontWeight.Thin,
//            fontSize = 25.dp,
            modifier = Modifier
                .padding(16.dp)
                .size(25.dp)
        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
//            fontSize = 15.dp,
            color = Color.Green,
            modifier = Modifier
                .padding(1.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardApplicationTheme {
        
    }
}