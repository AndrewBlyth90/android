package com.example.amphibians.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

@Serializable
data class Amphibian(
    val name: String,
    val imgSrc: String,
    val description: String,
    val type: String
)
