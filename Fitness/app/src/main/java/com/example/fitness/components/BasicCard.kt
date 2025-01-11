package com.example.fitness.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitness.R


@Preview(showBackground = true)
@Composable
fun BasicCard(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(82.dp)
            .fillMaxWidth()
    ){
        Text(text = "Create Workout", modifier = modifier.padding(16.dp).weight(1f))
        Image(
            painterResource(R.drawable.diary),
            null,
            modifier = modifier.clip(MaterialTheme.shapes.large))
    }
}