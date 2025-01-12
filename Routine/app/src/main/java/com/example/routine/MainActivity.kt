package com.example.routine

import BottomNavigationBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.routine.components.RoutineNavigationRail
import com.example.routine.pages.HomeScreen

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

@Preview
@Composable
fun RoutineAppPortrait(){
    AppTheme {
        Scaffold (bottomBar = { BottomNavigationBar() }) { padding ->
            HomeScreen(Modifier.padding(padding))
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

