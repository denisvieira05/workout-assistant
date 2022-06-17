package com.denisvieira05.workoutassistant.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.denisvieira05.workoutassistant.ui.theme.WorkoutAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutAssistantTheme {
                MyApp()
            }
        }
    }
}


