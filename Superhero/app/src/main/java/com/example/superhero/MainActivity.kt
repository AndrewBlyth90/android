package com.example.superhero

import SuperheroTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.superhero.model.heroes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    HeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroApp(){
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it, verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
            items(heroes) {
                HeroCard(
                    hero = it
                )
            }
        }
    }
}

@Composable
fun HeroListItem(hero: Hero, modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ){
            Column (
                modifier = Modifier.weight(1f)
            ) {
                HeroName(hero.heroNameRes)
                HeroDescription(hero.heroDescriptionRes)
            }
            Spacer(Modifier.width(16.dp))
            HeroImage(hero.heroImageRes)
        }
}

@Composable
fun HeroName(@StringRes heroName: Int, modifier: Modifier = Modifier){
    Text(
        text = stringResource(heroName),
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier.padding(
            bottom = dimensionResource(R.dimen.padding_small),
            top = dimensionResource(R.dimen.padding_medium))
    )
}

@Composable
fun HeroDescription(@StringRes heroDescription: Int, modifier: Modifier = Modifier){
    Text(
        text = stringResource(heroDescription),
        style = MaterialTheme.typography.bodyLarge,
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
            .clip(shape = MaterialTheme.shapes.small)
    )
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier.clip(shape = MaterialTheme.shapes.medium)
    ) {
        HeroListItem(
            hero
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroTheme {
        HeroApp()
    }
}