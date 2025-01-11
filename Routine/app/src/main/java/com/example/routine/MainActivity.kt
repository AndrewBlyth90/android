package com.example.routine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            App(windowSizeClass)
        }
    }
}


@Composable
fun WorkoutElement(
    @DrawableRes image: Int,
    @StringRes name: Int,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
        )
    }
}

@Composable
fun ExerciseCard(
    @DrawableRes image: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun WorkoutElementRow(
    modifier: Modifier = Modifier
){
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
    ){
        items(workoutData) { item ->
            WorkoutElement(item.drawable, item.text)
        }
    }
}

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
        items(excerciseData) { item ->
            ExerciseCard(item.drawable, item.text)
        }
    }
}

@Composable
fun BasicSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column(modifier){
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

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

@Preview
@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier){
    NavigationBar (
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            },
            label = { Text(text = stringResource(R.string.new_workout)) },
            selected = true,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun RoutineAppPortrait(){
    AppTheme {
        Scaffold (bottomBar = { BottomNavigationBar() }) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview
@Composable
fun RoutineNavigationRail(modifier: Modifier = Modifier){
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column (
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.new_workout))
                },
                selected = true,
                onClick = {}
            )
        }

    }
}

@Composable
fun RoutineAppLandscape(){
    AppTheme {
        Surface {
            Row {
                RoutineNavigationRail()
                HomeScreen()
            }
        }
    }
}

@Composable
fun App(windowSize: WindowSizeClass){
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            RoutineAppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            RoutineAppLandscape()
        }
    }
}

@Preview
@Composable
fun ExerciseCardPreview(){
    ExerciseCard(R.drawable.flat_bench_db_press, R.string.flat_bench_db_press)
}

@Preview
@Composable
fun WorkoutElementPreview(){
    WorkoutElement(R.drawable.dumbbell_biceps_curl, R.string.workout_1)
}

@Preview
@Composable
fun WorkoutSectionPreview(){
    BasicSection(title = R.string.workouts, modifier = Modifier) {
        WorkoutElementRow()
    }
}

private val workoutData = listOf(
    R.drawable.dumbbell_biceps_curl to R.string.workout_1,
    R.drawable.female_dumbbells_1296x728_header_1296x729 to R.string.workout_2,
    R.drawable.how_to_schedule_your_weekly_workout_routine_scaled to R.string.workout_3,
).map { DrawableStringPair(it.first, it.second) }

private val excerciseData = listOf(
    R.drawable.flat_bench_db_press to R.string.flat_bench_db_press,
    R.drawable.bent_over to R.string.bent_over_db_row,
    R.drawable.shoulder_press to R.string.seated_db_shoulder_press,
    R.drawable.lat_pulldown_ to R.string.lat_pull_down,
    R.drawable.goblet_squats to R.string.goblet_squat,
    R.drawable.reverse_lunge to R.string.reverse_lunges,
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)