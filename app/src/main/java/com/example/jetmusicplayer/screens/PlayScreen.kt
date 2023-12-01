package com.example.jetmusicplayer.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetmusicplayer.data.getSongsData
import com.example.jetmusicplayer.widgets.MusicButtonRow
import com.example.jetmusicplayer.widgets.PlayScreenTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    songId: String?
) {

    val newSongList = getSongsData().filter { song->
        song.id==songId
    }

    Scaffold(
        modifier = Modifier,
        topBar = { PlayScreenTopAppBar(navController = navController, songName = newSongList.first().songName) }
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
                    horizontalArrangement = Arrangement.Center
                ) {

                    LinearProgressIndicator(progress = 0.5f)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text=newSongList.first().duration)
                }


                MusicButtonRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )


            }

        }

    }
}

@Preview
@Composable
fun PlayScreenPreview() {
    val navController = rememberNavController()
    PlayScreen(navController = navController,songId="Song name")
}