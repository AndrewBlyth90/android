package com.example.a30daysofmusic.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysofmusic.R

data class Album(

    @StringRes val artistNameRes: Int,
    @StringRes val albumNameRes: Int,
    @StringRes val albumDescriptionRes: Int,
    @DrawableRes val albumImageRes: Int,
    val day: Int

)


val albums = listOf(
    Album(
        artistNameRes = R.string.alice_in_chains,
        albumNameRes = R.string.dirt,
        albumDescriptionRes = R.string.dirt_description,
        albumImageRes = R.drawable.aic_dirt,
        day = 1
    )
)
