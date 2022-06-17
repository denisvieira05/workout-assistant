package com.denisvieira05.workoutassistant.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.denisvieira05.workoutassistant.ui.screens.OnboardingScreen
import com.denisvieira05.workoutassistant.modules.welness.WellnessScreen
import com.denisvieira05.workoutassistant.ui.theme.WorkoutAssistantTheme

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun DefaultPreview() {
    WorkoutAssistantTheme {
        MyApp()
    }
}

@Composable
fun MyApp() {
    WorkoutAssistantTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            var shouldShowOnboarding by rememberSaveable { mutableStateOf(false) }

            if (shouldShowOnboarding) {
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            } else {
                WellnessScreen()
//                Conversation(SampleData.conversationSample)
            }
        }
    }
}