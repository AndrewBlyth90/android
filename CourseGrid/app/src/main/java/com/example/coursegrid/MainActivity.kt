package com.example.coursegrid

import android.os.Bundle
import android.os.ext.SdkExtensions
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import com.example.coursegrid.data.DataSource
import com.example.coursegrid.model.Course
import com.example.coursegrid.ui.theme.CourseGridTheme

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = SdkExtensions.AD_SERVICES, version = 4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseGridTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .padding(start = 8.dp, end = 8.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CourseGrid(DataSource.courses)
                }

            }
        }
    }
}

@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier) {
   Card(
       modifier = modifier.clip(RoundedCornerShape(5.dp, 5.dp, 0.dp, 0.dp))
   ){
       Box {
           Row {
               Image(
                   painter = painterResource(course.imageResourceId),
                   contentDescription = null,
                   modifier = modifier
                       .size(width = 68.dp, height = 68.dp)
                       .aspectRatio(1f)
               )
               Column(
                   modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
               ) {
                   Text(
                       text = stringResource(course.stringResourceId),
                       style = MaterialTheme.typography.bodyMedium                   )

                   Row (
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Image(
                           painter = painterResource(R.drawable.ic_grain),
                           contentDescription = null,
                           modifier = modifier.padding(end = 8.dp)
                       )
                       Text(
                           text = course.studentNumbers.toString(),
                           style = MaterialTheme.typography.labelMedium,
                       )
                   }
               }
           }
       }
   }
}


@Composable
fun CourseGrid(courseList: List<Course>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(courseList) { course ->
            CourseCard(course = course)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CourseGridTheme {
        CourseCard(Course(R.string.architecture, 58, R.drawable.architecture),
        )
    }
}