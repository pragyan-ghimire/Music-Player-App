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
            songImg = R.drawable.dandelions,
            songName = "Dandelions",
            authorName = "Ruth_B",
            duration="00:00",
            media=R.raw.ruth_b_dandelions
        ),
        SongsData(
            id="2",
            songImg = R.drawable.human,
            songName = "Human",
            authorName = "Ragnan Bone",
            duration="00:00",
            media = R.raw.human
        ),
        SongsData(
            id="3",
            songImg = R.drawable.ram_siya_ram,
            songName = "Ram Siya Ram",
            authorName = "Unknown author",
            duration="00:00",
            media=R.raw.ram_siya_ram
        ),
        SongsData(
            id="4",
            songImg = R.drawable.neele_neele_ambar,
            songName = "Neele Neele Ambar",
            authorName = "Kishor Kumar",
            duration="3:14",
            media=R.raw.neele_neele_ambar
        ),
        SongsData(
            id="5",
            songImg = R.drawable.me_myself_i,
            songName = "Me Myself and I",
            authorName = "Nightcore",
            duration="3:14",
            media = R.raw.me_myself_and_i
        ),
        SongsData(
            id="6",
            songImg = R.drawable.nach_meri_jaan,
            songName = "Naach Meri Jaan",
            authorName = "Unknown Author",
            duration="2:14",
            media = R.raw.naach_meri_jaan
        ),
        SongsData(
            id="7",
            songImg = R.drawable.samaya_samjhayega,
            songName = "Samay Samjhayega",
            authorName = "Unknown Author",
            duration="3:14",
            media = R.raw.samay_samjhayega
        ),
        SongsData(
            id="8",
            songImg = R.drawable.tum_prem_ho,
            songName = "Tum Prem Ho",
            authorName = "Unknown Author",
            duration="3:14",
            media=R.raw.tum_prem_ho
        ),
        SongsData(
            id="9",
            songImg = R.drawable.rumors,
            songName = "Rumors",
            authorName = "Neffex",
            duration="3:14",
            media=R.raw.neffex_rumors
        ),
    )
}
