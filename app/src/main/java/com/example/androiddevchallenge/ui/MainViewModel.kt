/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.DogInfo

class MainViewModel : ViewModel() {
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

    private val _selectedDog = MutableLiveData<DogInfo?>()
    val selectedDog: LiveData<DogInfo?> = _selectedDog

    fun showDogDetail(dogInfo: DogInfo) {
        _selectedDog.value = dogInfo
    }

    fun closeDogInfo() {
        _selectedDog.value = null
    }

    fun adoptDog(dogInfo: DogInfo) {
    }
}
