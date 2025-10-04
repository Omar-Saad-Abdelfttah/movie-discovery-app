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
    }
}






