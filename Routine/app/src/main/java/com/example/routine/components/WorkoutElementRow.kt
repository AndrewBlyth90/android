import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.routine.R
import com.example.routine.components.WorkoutElement
import com.example.routine.data.DrawableStringPair

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

private val workoutData = listOf(
    R.drawable.dumbbell_biceps_curl to R.string.workout_1,
    R.drawable.female_dumbbells_1296x728_header_1296x729 to R.string.workout_2,
    R.drawable.how_to_schedule_your_weekly_workout_routine_scaled to R.string.workout_3,
).map { DrawableStringPair(it.first, it.second) }


