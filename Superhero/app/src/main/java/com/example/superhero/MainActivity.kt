package com.example.superhero

import SuperheroTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {}
            }
        }
    }
}

@Composable
fun HeroListItem(hero: Hero, modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .height(dimensionResource(R.dimen.padding_xxlarge))
                .padding(dimensionResource(R.dimen.padding_small))
        ){
            Column {
                HeroName(hero.heroNameRes)
                HeroDescription(hero.heroDescriptionRes)
            }
            HeroImage(hero.heroImageRes)
        }
}

@Composable
fun HeroName(@StringRes heroName: Int, modifier: Modifier = Modifier){
    Text(
        text = stringResource(heroName),
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun HeroDescription(@StringRes heroDescription: Int, modifier: Modifier = Modifier){
    Text(
        text = stringResource(heroDescription),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun HeroImage(@DrawableRes heroImage: Int, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(heroImage),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(start = dimensionResource(R.dimen.padding_medium))
            .clip(shape = MaterialTheme.shapes.small)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroTheme {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            modifier = Modifier.clip(shape = MaterialTheme.shapes.medium)
        ) {
            HeroListItem(
                Hero(
                    heroNameRes = R.string.hero1,
                    heroDescriptionRes = R.string.description1,
                    heroImageRes = R.drawable.android_superhero1
                )
            )
        }
    }
}