package com.example.jetmusicplayer.widgets

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetmusicplayer.R
import com.example.jetmusicplayer.data.PlaylistData
import com.example.jetmusicplayer.data.SongsData
import com.example.jetmusicplayer.data.getPlaylistData
import com.example.jetmusicplayer.data.getSongsData
import com.example.jetmusicplayer.navigations.NavigationScreens
import com.example.jetmusicplayer.screens.PlayScreen

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun HomeTopAppBar(){

    TopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.profie_picture),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Pragyan Ghimire",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.width(90.dp))

            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Settings Icon",
//                        tint = MaterialTheme.colorScheme.surfaceTint
            )
        }
    })
}

//@Preview
@Composable
fun PlaylistRow(
    modifier: Modifier = Modifier,
    playlist: List<PlaylistData> = getPlaylistData(),
    onItemClick:() -> Unit ={}
){
    LazyRow(
        modifier=modifier
    ){
        items(playlist){
            ElevatedCard (
                modifier= Modifier
                    .padding(horizontal = 16.dp)
                    .size(200.dp)
                    .clickable {
                        onItemClick
                    },
                shape = MaterialTheme.shapes.small
            ){
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription ="Details Icon"
                )
                Column(
                    modifier= Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier= Modifier
                            .size(100.dp)
                            .clip(shape = CircleShape),
                        painter = painterResource(id = it.image),
                        contentDescription ="SongType Image",
                        contentScale = ContentScale.Crop

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = it.typeText,
                        style= TextStyle(
                            fontSize=18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }

        }
    }
}

//@Preview
@Composable
fun SongsColumn(
    modifier: Modifier = Modifier,
    songsList: List<SongsData> = getSongsData(),
    navController: NavController
){
    LazyColumn(
        modifier= Modifier
    ){
        items(songsList){
            Surface(
                modifier = Modifier.clickable {
                    Log.i("SongClicked",it.songName)
                    navController.navigate(route = NavigationScreens.PlayScreen.name+"/${it.id}")
                }
            ){
                Row (
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Image(
                        modifier= Modifier
                            .size(40.dp)
                            .clip(shape = CircleShape),
                        painter = painterResource(id = it.songImg),
                        contentDescription ="Songs Picture",
                        contentScale = ContentScale.Crop)
                    Column(
                        modifier= Modifier.padding(horizontal = 16.dp)
                    ){
                        Text(text = it.songName,
                            style= MaterialTheme.typography.titleLarge)
                        Text(text = it.authorName,
                            style= MaterialTheme.typography.labelLarge)
                    }


                }
            }
            Divider(thickness = 1.dp)
        }

    }
}

