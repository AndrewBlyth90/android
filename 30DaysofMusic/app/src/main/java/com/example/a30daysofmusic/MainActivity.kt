package com.example.a30daysofmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.a30daysofmusic.model.albums
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MusicApp()
            }
        }
    }
}

@Composable
fun MusicApp(){
    Scaffold (
        topBar = { MusicTopAppBar() }
    ) { it ->
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn (
                contentPadding = it
            ) {
                items(albums) {
                    AlbumItemCard(album = it)
                }
            }
        }
    }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
       MusicApp()
    }
}