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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.default_card_padding
import com.example.androiddevchallenge.model.DogInfo
import com.example.androiddevchallenge.ui.MainViewModel
import com.example.androiddevchallenge.ui.page.DogDetailPage
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: MainViewModel) {
    val currentDog: DogInfo? by viewModel.selectedDog.observeAsState(null)

    Surface(color = MaterialTheme.colors.background) {

        if (currentDog != null) {
            //show dog detail
            DogDetailPage(dog = currentDog!!, viewModel)
        } else {
            //show dog list
            Column {
                PuppiesListTopBar()
                LazyColumn {
                    items(viewModel.dogs) {
                        InfoCard(it) { dog ->
                            viewModel.showDogDetail(dog)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun PuppiesListTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(56.dp)
            .padding(8.dp),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Row {
            Text(text = "Log in")
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                tint = MaterialTheme.colors.primary,
            )
        }

    }
}

@Composable
fun InfoCard(dogInfo: DogInfo, onClick: (DogInfo) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(dogInfo)
            },
        elevation = 1.dp
    ) {
        Column(
            Modifier
                .background(color = Color.White)
                .padding(default_card_padding)
                .fillMaxWidth()

        ) {
            Column {
                Text(dogInfo.name, style = MaterialTheme.typography.h6)
                Text(dogInfo.gender)
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
