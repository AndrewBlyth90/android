package com.example.superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superhero.R

data class Hero(
    @StringRes val heroNameRes: Int,
    @StringRes val heroDescriptionRes: Int,
    @DrawableRes  val heroImageRes: Int
)

val heroes = listOf(
    Hero(
        heroNameRes = R.string.hero1,
        heroDescriptionRes = R.string.description1,
        heroImageRes = R.drawable.android_superhero1
    ),
    Hero(
        heroNameRes = R.string.hero2,
        heroDescriptionRes = R.string.description2,
        heroImageRes = R.drawable.android_superhero2
    ),
    Hero(
        heroNameRes = R.string.hero3,
        heroDescriptionRes = R.string.description3,
        heroImageRes = R.drawable.android_superhero3
    ),
    Hero(
        heroNameRes = R.string.hero4,
        heroDescriptionRes = R.string.description4,
        heroImageRes = R.drawable.android_superhero4
    ),
    Hero(
        heroNameRes = R.string.hero5,
        heroDescriptionRes = R.string.description5,
        heroImageRes = R.drawable.android_superhero5
    ),
    Hero(
        heroNameRes = R.string.hero6,
        heroDescriptionRes = R.string.description6,
        heroImageRes = R.drawable.android_superhero6
    )
)
