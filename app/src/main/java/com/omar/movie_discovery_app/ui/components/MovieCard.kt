package com.omar.movie_discovery_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.omar.movie_discovery_app.model.Movie
import com.google.accompanist.placeholder.*
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun MovieCard(movie: Movie, onClick: (Movie) -> Unit) {

    val painter = rememberAsyncImagePainter(movie.imageUrl)
    val isLoading = painter.state is AsyncImagePainter.State.Loading

    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .clickable { onClick(movie) }
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF1C1C1C))
    ) {

        Image(
            painter = painter,
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color.DarkGray
                ),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(Color(0xAA000000))
                .padding(6.dp)
        ) {
            Text(
                text = movie.title,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color.DarkGray
                )
            )
        }
    }
}
