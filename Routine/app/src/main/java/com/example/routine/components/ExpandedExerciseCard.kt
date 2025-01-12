package com.example.routine.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.routine.R

@Preview
@Composable
fun ExpandedExerciseCard(modifier: Modifier = Modifier){
    Card(){
        Column(
        ){
            Image(
                painter = painterResource(R.drawable.flat_bench_db_press),
                null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                )
            Spacer(Modifier.padding(8.dp))
            Text(text = "Flat Bench DB Press", Modifier.padding(16.dp))
            SetChecklist(Modifier.padding(16.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
                ) {
                    Text("Add New Set")
                }
            }
        }
    }
}

@Preview
@Composable
fun SetChecklist(modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text("5 x 5kg")
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}