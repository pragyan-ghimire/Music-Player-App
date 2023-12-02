package com.example.jetmusicplayer.screens

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetmusicplayer.data.getSongsData
import com.example.jetmusicplayer.widgets.MusicButtonRow
import com.example.jetmusicplayer.widgets.PlayScreenTopAppBar
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    songId: String?,
) {

    val newSongList = getSongsData().filter { song ->
        song.id == songId
    }
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(context, newSongList.first().media)
    }
    val sliderState = remember {
        mutableStateOf(0f)
    }


    DisposableEffect(mediaPlayer) {
        onDispose {
            mediaPlayer.release()
        }
    }


//    Log.i("duration","PlayScreen: ${mediaPlayer.duration}")
    val minute = mediaPlayer.duration / 60000
//    Log.i("duration", "PlayScreen: $minute")
    val rem: Int = mediaPlayer.duration % 60000
//    Log.i("duration", "PlayScreen: $rem")
    val sec = rem.toString().substring(0, 2)
    Log.i("duration", "PlayScreen: $sec")




    Scaffold(
        modifier = Modifier,
        topBar = {
            PlayScreenTopAppBar(
                navController = navController,
                songName = newSongList.first().songName,
                mediaPlayer = mediaPlayer
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(paddingValues = it)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = newSongList.first().songImg),
                    contentDescription = "Song Image",
                    modifier = Modifier
                        .size(300.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = newSongList.first().songName,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = newSongList.first().authorName,
                        style = MaterialTheme.typography.labelLarge
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    sliderState.value = mediaPlayer.currentPosition.toFloat()

                    Slider(
                        //TODO: update slider and Text(text = "$minute:$sec") not showing 
                        value = sliderState.value,
                        onValueChange = {
                            sliderState.value =it
                        },
                        onValueChangeFinished = {
                            mediaPlayer.seekTo(sliderState.value.toInt())
                        },
                        valueRange = 0f..mediaPlayer.duration.toFloat()
                    )
                    Log.d("PlayScreen", "Minute: $minute, Second: $sec")
                    Text(text = "$minute:$sec")

                }


                MusicButtonRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    mediaPlayer = mediaPlayer
                )


            }


        }

    }
}

@Preview
@Composable
fun PlayScreenPreview() {
    val navController = rememberNavController()
    PlayScreen(navController = navController, songId = "Song name")
}