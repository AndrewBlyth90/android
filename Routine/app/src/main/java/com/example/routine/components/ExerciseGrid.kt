package com.example.routine.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.routine.R
import com.example.routine.data.DrawableStringPair


@Preview
@Composable
fun ExerciseGrid(
    modifier: Modifier = Modifier
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(exerciseData) { item ->
            ExerciseCard(item.drawable, item.text)
        }
    }
}

private val exerciseData = listOf(
    R.drawable.dumbbell_biceps_curl to R.string.flat_bench_db_press,
    R.drawable.bent_over to R.string.bent_over_db_row,
    R.drawable.shoulder_press to R.string.seated_db_shoulder_press,
    R.drawable.lat_pulldown_ to R.string.lat_pull_down,
    R.drawable.goblet_squats to R.string.goblet_squat,
    R.drawable.reverse_lunge to R.string.reverse_lunges,
).map { DrawableStringPair(it.first, it.second) }