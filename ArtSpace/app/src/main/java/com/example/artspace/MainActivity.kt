package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                PageContainer()
            }
        }
    }
}

@Composable
fun PageContainer(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = R.drawable.doorstep),
            contentDescription = "",
            modifier = Modifier
                .width(400.dp)
                .shadow(elevation = 10.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        TitleHolder()
        Spacer(modifier = Modifier.height(20.dp))
        ButtonRow()
    }
}

@Composable
fun TitleHolder(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.doorstep)
        )
        Text(text = stringResource(id = R.string.andrew))
    }
}

@Composable
fun ButtonRow(){
    Row {
        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)) {
            Text("Previous")
        }
        Spacer(modifier = Modifier.width(40.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)) {
            Text("Next")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        PageContainer()
    }
}