package com.example.androiddevchallenge.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.DogInfo
import com.example.androiddevchallenge.ui.MainViewModel

@Composable
fun DogDetailPage(dog: DogInfo, viewModel: MainViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
    ) {
        Box {
            Image(
                painterResource(dog.picture),
                "Dog: ${dog.name}",
                Modifier.aspectRatio(1.3f),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = MaterialTheme.shapes.small,
                    )
                    .clickable { viewModel.closeDogInfo() }
                    .padding(4.dp),
            )
            FloatingActionButton(
                onClick = { viewModel.adoptDog(dog) },
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "like",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                        .clickable { viewModel.closeDogInfo() }
                        .padding(4.dp),
                    tint = MaterialTheme.colors.primary
                )
            }
        }
        Column(Modifier.padding(24.dp, 8.dp)) {
            Text("Name: ${dog.name}", style = MaterialTheme.typography.h5)
            Row {
                Chip(dog.breed)
                Chip(dog.gender)
            }
            Spacer(modifier = Modifier.size(4.dp))
            ProvideTextStyle(MaterialTheme.typography.body1) {
                Text("Location: ${dog.location}")
                Text("Age: ${dog.age}")
                Text("Size: ${dog.size}")
            }
        }
    }
}

@Composable
fun Chip(text: String) {
    val radius = 8.dp
    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 2.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(radius))
    ) {
        Text(text = " $text ", color = Color.White)
    }
}