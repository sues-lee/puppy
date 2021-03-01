package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class DogInfo (
    val name: String,
    val breed: String,
    val location: String,
    val age: String,
    val gender: String,
    val size: String,
    @DrawableRes val picture: Int,
)