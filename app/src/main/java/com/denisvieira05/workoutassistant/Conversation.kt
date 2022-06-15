package com.denisvieira05.workoutassistant

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.denisvieira05.workoutassistant.ui.theme.WorkoutAssistantTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    WorkoutAssistantTheme {
        Conversation(SampleData.conversationSample)
    }
}
