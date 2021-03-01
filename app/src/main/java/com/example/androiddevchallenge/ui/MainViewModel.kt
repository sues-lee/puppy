package com.example.androiddevchallenge.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.DogInfo

class MainViewModel: ViewModel() {
    val dogs by mutableStateOf(
        listOf(
            DogInfo(
                "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
                "Adult", "Female", "Large", R.drawable.img_puppy_nala
            ),
            DogInfo(
                "Lulu", "Terrier Mix", "Sunnyvale, CA",
                "Young", "Female", "Medium", R.drawable.img_puppy_lulu
            ),
            DogInfo(
                "Billy", "American Staffordshire Terrier Mix", "Sunnyvale, CA",
                "Adult", "Male", "Large", R.drawable.img_puppy_billy
            ),
            DogInfo(
                "Arnie", "Chihuahua Mix", "Mountain View, CA",
                "Young", "Male", "Small", R.drawable.img_puppy_arnie
            ),
            DogInfo(
                "Doby", "Mountain DogInfo & Shepherd Mix", "Sunnyvale, CA",
                "Puppy", "Female", "Medium", R.drawable.img_puppy_doby
            ),
            DogInfo(
                "Bowen", "Mountain DogInfo & Shepherd Mix", "Sunnyvale, CA",
                "Puppy", "Male", "Medium", R.drawable.img_puppy_bowen
            ),
            DogInfo(
                "Rumi", "Border Collie & German Shepherd DogInfo Mix", "Los Altos, CA",
                "Young", "Male", "Medium", R.drawable.img_puppy_rumi
            ),
            DogInfo(
                "Mikey", "Chihuahua & Rat Terrier Mix", "Santa Clara, CA",
                "Young", "Male", "Medium", R.drawable.img_puppy_mikey
            ),
            DogInfo(
                "Layla", "Chihuahua & Terrier Mix", "Santa Clara, CA",
                "Young", "Female", "Medium", R.drawable.img_puppy_layla
            ),
            DogInfo(
                "Tessie", "Pit Bull Terrier Mix", "Santa Clara, CA",
                "Adult", "Female", "Large", R.drawable.img_puppy_tessie
            ),
            DogInfo(
                "Sia", "Pit Bull Terrier", "Santa Clara, CA",
                "Young", "Female", "Medium", R.drawable.img_puppy_sia
            ),
        )
    )
}