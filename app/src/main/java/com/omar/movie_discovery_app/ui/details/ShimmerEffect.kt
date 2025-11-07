package com.omar.movie_discovery_app.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.ShimmerBounds

@Composable
fun ShimmerEffect(modifier: Modifier = Modifier) {

    val shimmer = rememberShimmer(
        shimmerBounds = ShimmerBounds.Window
    )

    Box(
        modifier
            .shimmer(shimmer)
            .background(Color(0xFF1E1E1E))
    )
}
