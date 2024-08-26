package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var result by remember {
        mutableIntStateOf(1)
    }

    val imageResource = when (result) {
        1 -> R.drawable.doorstep
        2 -> R.drawable.finn
        3 -> R.drawable.jilly
        4 -> R.drawable.morag
        5 -> R.drawable.pathway
        else -> R.drawable.sploot
    }

    val stringResource = when (result) {
        1 -> R.string.doorstep
        2 -> R.string.finn
        3 -> R.string.jilly
        4 -> R.string.morag
        5 -> R.string.pathway
        else -> R.string.sploot
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = imageResource),
            contentDescription = "",
            modifier = Modifier
                .width(400.dp)
                .shadow(elevation = 10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        TitleHolder(stringResource = stringResource)

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = {
                result = orderChecker(result, "previous")
            }, modifier = Modifier.width(150.dp)) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(onClick = {
                result = orderChecker(result, "next")
            }, modifier = Modifier.width(150.dp)) {
                Text("Next")
            }
        }

    }
}

@Composable
fun TitleHolder(
    @StringRes stringResource: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = stringResource)
        )
        Text(text = stringResource(id = R.string.andrew))
    }
}

fun orderChecker (number: Int, buttonDirection: String ): Int {

    if(buttonDirection == "previous"){
        if(number == 1){
            return 6
        }
        return number - 1
    }

    if (number == 6){
        return 1
    }
    if (number == 0){
        return 1
    }
    return number + 1
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        PageContainer()
    }
}