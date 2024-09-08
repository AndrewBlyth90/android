package com.example.a30daysofmusic.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysofmusic.R

data class Album(

    @StringRes val artistNameRes: Int,
    @StringRes val albumNameRes: Int,
    @StringRes val albumDescriptionRes: Int,
    @DrawableRes val albumImageRes: Int,

)

val albums = listOf(
    Album(
        artistNameRes = R.string.alice_in_chains,
        albumNameRes = R.string.dirt,
        albumDescriptionRes = R.string.dirt_description,
        albumImageRes = R.drawable.aic_dirt,
    ),
    Album(
        artistNameRes = R.string.blink_182,
        albumNameRes = R.string.take_off,
        albumDescriptionRes = R.string.take_off_description,
        albumImageRes = R.drawable.blink_182_take_off_your_pants_and_jacket_cover
    ),
    Album(
        artistNameRes = R.string.black_sabbath,
        albumNameRes = R.string.masters_of_reality,
        albumDescriptionRes = R.string.masters_of_reality_desc,
        albumImageRes = R.drawable.bs_masters,
    ),
    Album(
        artistNameRes = R.string.danzig,
        albumNameRes = R.string.lucifuge,
        albumDescriptionRes = R.string.lucifuge_desc,
        albumImageRes = R.drawable.danzig_lucifuge
    ),
    Album(
        artistNameRes = R.string.death,
        albumNameRes = R.string.symbolic,
        albumDescriptionRes = R.string.symbolic_desc,
        albumImageRes = R.drawable.death_symbolic,
    )


)
