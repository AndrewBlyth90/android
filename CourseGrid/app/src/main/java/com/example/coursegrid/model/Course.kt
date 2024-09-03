package com.example.coursegrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course (
    @StringRes val stringResourceId: Int,
    val studentNumbers: Int,
    @DrawableRes val imageResourceId: Int
)