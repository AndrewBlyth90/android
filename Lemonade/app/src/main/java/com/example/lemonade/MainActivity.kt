package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun Title(modifier: Modifier = Modifier){
    Text(
        text = stringResource(R.string.lemonade_title),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        modifier = modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun AppContent(){

    var buttonImage by remember {
        mutableIntStateOf(0)
    }

    var phrase by remember {
        mutableStateOf(0)
    }

    val drawResource = when (buttonImage) {
        0 -> R.drawable.lemon_tree
        1,2,3,4,5 -> R.drawable.lemon_squeeze
        6 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val stringResource = when (phrase) {
        0 -> R.string.select_lemon
        1,2,3,4,5 -> R.string.squeeze_lemon
        6 -> R.string.drink_lemonade
        else -> R.string.tap_empty_glass
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {

                    buttonImage = if(buttonImage in 0..<7){
                        buttonImage + 1
                    } else {
                        0
                    }

                    phrase = if(phrase in 0..<7){
                        phrase + 1
                    } else {
                        0
                    }
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                modifier = Modifier
                    .width(200.dp)
                    .height(250.dp)
            ) {
            }
            Image(
                painter = painterResource(drawResource),
                contentDescription = "1"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(stringResource),
            fontSize = 18.sp
        )
    }
}


@Preview
@Composable
fun LemonadeApp(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .background(Color.White)
    ){
        Title()
        AppContent()
    }
}