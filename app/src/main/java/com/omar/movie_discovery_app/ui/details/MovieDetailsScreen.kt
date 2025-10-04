package com.omar.movie_discovery_app.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val rating: Double,
    val runtime: String,
    val year: Int
)
@Composable
fun MovieDetailsScreen(movie: Movie, modifier: Modifier = Modifier) {
    val backgroundColor = Color(0xFF0B1220)
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            // Poster
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = "${movie.title} poster",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(18.dp))

            // Title
            Text(
                text = movie.title,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Rating + runtime + year
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "rating",
                    tint = Color(0xFFFFD24D)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = String.format("%.1f", movie.rating), color = Color.LightGray)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = movie.runtime, color = Color.Gray)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = movie.year.toString(), color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(18.dp))

        }
    }
}






