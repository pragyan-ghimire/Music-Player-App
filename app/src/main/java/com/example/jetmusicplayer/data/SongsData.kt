package com.example.jetmusicplayer.data

import com.example.jetmusicplayer.R

data class SongsData(
    val id: String,
    val songImg: Int,
    val songName: String,
    val authorName: String,
    val duration: String,
    val media: Int,
)

fun getSongsData(): List<SongsData>{
    return listOf(
        SongsData(
            id="1",
            songImg = R.drawable.profie_picture,
            songName = "Dandelions",
            authorName = "Ruth_B",
            duration="00:00",
            media=R.raw.Ruth_B_Dandelions
        ),
        SongsData(
            id="2",
            songImg = R.drawable.profie_picture,
            songName = "Human",
            authorName = "Ragnan Bone",
            duration="00:00",
            media = R.raw.Human
        ),
        SongsData(
            id="3",
            songImg = R.drawable.profie_picture,
            songName = "Ram Siya Ram",
            authorName = "Unknown author",
            duration="00:00",
            media=R.raw.Ram_Siya_Ram
        ),
        SongsData(
            id="4",
            songImg = R.drawable.profie_picture,
            songName = "Neele Neele Ambar",
            authorName = "Kishor Kumar",
            duration="3:14",
            media=R.raw.Neele_Neele_Ambar
        ),
        SongsData(
            id="5",
            songImg = R.drawable.profie_picture,
            songName = "Me Myself and I",
            authorName = "Nightcore",
            duration="3:14",
            media = R.raw.Me_Myself_and_I
        ),
        SongsData(
            id="6",
            songImg = R.drawable.profie_picture,
            songName = "Naach Meri Jaan",
            authorName = "Unknown Author",
            duration="2:14",
            media = R.raw.Naach_Meri_Jaan
        ),
        SongsData(
            id="7",
            songImg = R.drawable.profie_picture,
            songName = "Samay Samjhayega",
            authorName = "Unknown Author",
            duration="3:14",
            media = R.raw.Samay_Samjhayega
        ),
        SongsData(
            id="8",
            songImg = R.drawable.profie_picture,
            songName = "Tum Prem Ho",
            authorName = "Unknown Author",
            duration="3:14",
            media=R.raw.Tum_Prem_Ho
        ),
    )
}
