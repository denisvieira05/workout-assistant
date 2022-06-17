package com.denisvieira05.workoutassistant.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denisvieira05.workoutassistant.data.SampleData
import com.denisvieira05.workoutassistant.model.Message
import com.denisvieira05.workoutassistant.ui.components.MessageCard
import com.denisvieira05.workoutassistant.ui.theme.WorkoutAssistantTheme
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextLayoutResult
import com.denisvieira05.workoutassistant.R

@Composable
fun Conversation(messages: List<Message>) {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val showScrollToTopButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }

    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    val textLayoutResult = textLayoutResultState.value

    LaunchedEffect(textLayoutResult) {

    }
    Scaffold(
        floatingActionButton = {
            println("change: "+showScrollToTopButton)
            if (showScrollToTopButton){
                ScrollToTopButton {
                    coroutineScope.launch {
                        state.animateScrollToItem(0)
                    }
                }
            }
        },
        isFloatingActionButtonDocked = true,
//        floatingActionButtonPosition = FabPosition.Center,
        ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            MainList(state, messages)
        }
    }

}

@Composable
fun ScrollToTopButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = {
            Icon(
                Icons.Filled.KeyboardArrowUp,
                contentDescription = "Favorite",
                tint = Color.White
            )
        },
        text = { Text(color = Color.White, text ="Scroll to Top") }
    )
}

@Composable
fun MainList(state: LazyListState, messages: List<Message>) {
    LazyColumn(
        state = state,
        modifier = Modifier.padding(end = 16.dp, start = 16.dp)
    ) {
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
