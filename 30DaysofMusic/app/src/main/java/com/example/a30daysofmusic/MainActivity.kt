package com.example.a30daysofmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofmusic.model.Album
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlbumItemCard(album =
                    Album(
                        artistNameRes = R.string.alice_in_chains,
                        albumNameRes = R.string.dirt,
                        albumDescriptionRes = R.string.dirt_description,
                        albumImageRes = R.drawable.aic_dirt,
                        day = 1
                    ))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun AlbumItemCard(album: Album){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .width(
                dimensionResource(R.dimen.image_size)
            )
    ){

        Image(
            painter = painterResource(album.albumImageRes),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
        )
        Text(
            text = stringResource(album.artistNameRes),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_small)
            )
        )
        Text(
            text = stringResource(album.albumNameRes),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium)
            )
        )
        Text(
            text = stringResource(album.albumDescriptionRes),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        AlbumItemCard(
            Album(
            artistNameRes = R.string.alice_in_chains,
            albumNameRes = R.string.dirt,
            albumDescriptionRes = R.string.dirt_description,
            albumImageRes = R.drawable.aic_dirt,
            day = 1
        )
        )
    }
}