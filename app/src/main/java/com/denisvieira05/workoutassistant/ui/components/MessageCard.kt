package com.denisvieira05.workoutassistant.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.denisvieira05.workoutassistant.R
import com.denisvieira05.workoutassistant.data.SampleData
import com.denisvieira05.workoutassistant.model.Message
import com.denisvieira05.workoutassistant.ui.theme.WorkoutAssistantTheme
import com.denisvieira05.workoutassistant.ui.utils.getRandomColor

@Preview
@Composable
fun PreviewMessageCard() {
    WorkoutAssistantTheme {
        MessageCard(SampleData.conversationSample[0])
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://developer.android.com/images/jetpack/compose-tutorial/profile_picture.png")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp).align(Alignment.CenterVertically),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Surface(modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    fontWeight = FontWeight.Bold,
                    color = getRandomColor(),
                    text = message.author
                )
                Spacer(modifier = Modifier.padding(all = 4.dp))
                ExpandingText(
                    modifier = Modifier.padding(5.dp),
                    text = message.body
                )
            }
        }

    }
}

