package com.example.jetmusicplayer.widgets

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetmusicplayer.components.MusicButton
import com.example.jetmusicplayer.data.SongsData

//Play Screen

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun PlayScreenTopAppBar(
    songName: String = "Song Name",
    onDetailsClicked: () -> Unit = {},
    navController: NavController,
    mediaPlayer: MediaPlayer
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MusicButton(
                    icon = Icons.Filled.ArrowBack,
                    description = "Back Arrow",
                    onClick = {
                        mediaPlayer.stop()
                        navController.popBackStack()
                    }
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Now playing",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                    Text(
                        text = songName,
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp
                        )
                    )
                }
                MusicButton(
                    icon = Icons.Rounded.List,
                    description = "details icon",
                    onClick = onDetailsClicked
                )
            }

        })
}

//@Preview(showBackground = true)
@Composable
fun MusicButtonRow(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    mediaPlayer: MediaPlayer,

) {
    val context= LocalContext.current
    val playState = remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        MusicButton(
            icon = Icons.Default.SkipPrevious,
            description = "Previous song",
            modifier = Modifier.clickable {

            }
        )
        IconToggleButton(
            checked = playState.value,
            onCheckedChange = {
                playState.value = !playState.value
                if(playState.value){
//                    if (mediaPlayer.currentPosition!=0){
//                        mediaPlayer.seekTo(mediaPlayer.currentPosition)
//                        mediaPlayer.start()
//                    }else
                    mediaPlayer.start()
                    Log.d("media", "media Started")
                }
                else{
                    mediaPlayer.pause()
                    Log.d("media", "media pause")
                }
            }
        ) {
            mediaPlayer.setOnCompletionListener{
                it.pause()
                it.seekTo(0)
                playState.value=!playState.value
                Log.d("media", "Completed ")
            }
            Icon(
                imageVector = if (playState.value) {
                    Icons.Default.Pause
                } else {
                    Icons.Default.PlayArrow
                }, contentDescription = "Play/Pause/Resume",
                modifier = Modifier
                    .size(50.dp)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape),
                tint = MaterialTheme.colorScheme.background
            )
        }

        MusicButton(
            icon = Icons.Default.SkipNext,
            description = "Next song"
        )
    }
}


