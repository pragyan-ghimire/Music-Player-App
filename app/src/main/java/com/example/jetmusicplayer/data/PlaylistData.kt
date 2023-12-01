package com.example.jetmusicplayer.data

import com.example.jetmusicplayer.R

data class PlaylistData(
    val image: Int,
    val typeText: String,
)
fun getPlaylistData():List<PlaylistData>{
    return listOf(
        PlaylistData(
            image = R.drawable.profie_picture,
            typeText = "Metal"
        ),
        PlaylistData(
            image = R.drawable.profie_picture,
            typeText = "Rock"
        ),
        PlaylistData(
            image = R.drawable.profie_picture,
            typeText = "Swift"
        ),
        PlaylistData(
            image = R.drawable.profie_picture,
            typeText = "Instrumental"
        ),

    )
}
