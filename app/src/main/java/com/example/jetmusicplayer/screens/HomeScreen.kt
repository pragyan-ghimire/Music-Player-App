package com.example.jetmusicplayer.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetmusicplayer.widgets.PlaylistRow
import com.example.jetmusicplayer.widgets.HomeTopAppBar
import com.example.jetmusicplayer.widgets.SongsColumn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            HomeTopAppBar()
        }
    ) {
        Surface(
            modifier = modifier.padding(paddingValues = it)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
//                    .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Playlists",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Text(
                        text = "View All",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }

                PlaylistRow(modifier = Modifier.padding(top = 16.dp))

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Songs",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )

                SongsColumn(
                    modifier = Modifier.padding(top = 16.dp),
                    navController = navController
                )

            }

        }


    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}