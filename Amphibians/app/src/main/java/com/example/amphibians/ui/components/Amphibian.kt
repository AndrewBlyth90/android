package com.example.amphibians.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.amphibians.data.Amphibian
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibians.R


val mockAmphibian = Amphibian(
    name = "Great Basin Spadefoot",
    imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png",
    description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
    type = "Toad"
)


@Composable
fun AmphibianCard(modifier: Modifier = Modifier, amphibian: Amphibian){

    Column {

        Row(modifier = modifier.padding(16.dp)){
            Text(
                text = amphibian.name,
                modifier = modifier
            )
            Text(
                text = "(" + amphibian.type + ")",
                modifier = modifier.padding(start = 8.dp)
            )
        }

        AsyncImage(
            model = amphibian.imgSrc,
            placeholder = painterResource(R.drawable.great_basin_spadefoot),
            contentDescription = null,
            modifier = modifier.fillMaxWidth()
        )

        Text(
            text = amphibian.description,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun AmphibianPreview(){
    AmphibianCard(amphibian = mockAmphibian)
}