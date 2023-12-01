package com.example.jetmusicplayer.data

import com.example.jetmusicplayer.R

data class SongsData(
    val id: String,
    val songImg: Int,
    val songName: String,
    val authorName: String,
    val duration: String,
)

fun getSongsData(): List<SongsData>{
    return listOf(
        SongsData(
            id="1",
            songImg = R.drawable.profie_picture,
            songName = "A Thousand Years",
            authorName = "Christina Perri",
            duration="3:14"
        ),
        SongsData(
            id="2",
            songImg = R.drawable.profie_picture,
            songName = "Perfect",
            authorName = "Ed Sheeran",
            duration="2:14"
        ),
        SongsData(
            id="3",
            songImg = R.drawable.profie_picture,
            songName = "Audio",
            authorName = "Unknown author",
            duration="1:14"
        ),
        SongsData(
            id="4",
            songImg = R.drawable.profie_picture,
            songName = "Main rahoon na rahoon",
            authorName = "Arjit Singh",
            duration="3:14"
        ),
        SongsData(
            id="5",
            songImg = R.drawable.profie_picture,
            songName = "A Thousand Years",
            authorName = "Christina Perri",
            duration="3:14"
        ),
        SongsData(
            id="6",
            songImg = R.drawable.profie_picture,
            songName = "Perfect",
            authorName = "Ed Sheeran",
            duration="2:14"
        ),
        SongsData(
            id="7",
            songImg = R.drawable.profie_picture,
            songName = "A Thousand Years",
            authorName = "Christina Perri",
            duration="3:14"
        ),
        SongsData(
            id="8",
            songImg = R.drawable.profie_picture,
            songName = "A Thousand Years",
            authorName = "Christina Perri",
            duration="3:14"
        ),
    )
}
