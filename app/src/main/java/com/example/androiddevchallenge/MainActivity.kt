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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatViewInflater
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.default_card_padding
import com.example.androiddevchallenge.model.DogInfo
import com.example.androiddevchallenge.ui.MainViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel.dogs)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(dogList: List<DogInfo>) {
    Surface(color = MaterialTheme.colors.background) {

        LazyColumn{
            dogList.forEach {
                item {
                    Card(
                        modifier = Modifier.padding(8.dp),
                        elevation = 1.dp
                    ) {
                        InfoCard(it)
                    }
                }
            }
        }

    }
}

@Composable
fun InfoCard(dogInfo: DogInfo){
    Column(
        Modifier
            .background(color = Color.White)
            .padding(default_card_padding)
            .fillMaxWidth()
    ) {
        Column {
            Text(dogInfo.name)
            Text(dogInfo.age)
        }
        
        Spacer(Modifier.size(6.dp))
        
        Card(elevation = 4.dp) {
            Image(
                painterResource(dogInfo.picture),
                "Dog picture: ${dogInfo.name}",
                Modifier.aspectRatio(2f),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun cardPreview(){
    MyTheme {
        InfoCard(  DogInfo(
            "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
            "Adult", "Female", "Large", R.drawable.img_puppy_nala
        ))
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        // MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        // MyApp()
    }
}
