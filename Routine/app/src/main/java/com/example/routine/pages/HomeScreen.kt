package com.example.routine.pages

import WorkoutElementRow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.routine.R
import com.example.routine.components.BasicSection
import com.example.routine.components.ExerciseGrid

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        BasicSection(title = R.string.workouts) {
            WorkoutElementRow()
        }
        BasicSection(title = R.string.exercises) {
            ExerciseGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}
