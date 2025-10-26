package com.omar.movie_discovery_app.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.ui.unit.dp


@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1200)
        )
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 800)
        )
        delay(600)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "🎬 Movie Discovery",
                color = Color.White.copy(alpha = alpha.value),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.scale(scale.value)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Find your next favorite movie",
                color = Color.Gray.copy(alpha = alpha.value),
                fontSize = 14.sp
            )
        }
    }
}
