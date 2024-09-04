package com.example.superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val heroNameRes: Int,
    @StringRes val heroDescriptionRes: Int,
    @DrawableRes  val heroImageRes: Int
)
