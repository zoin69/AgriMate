package com.example.agrimate.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PageTransition(
    targetState: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = targetState,
        enter = slideInHorizontally(
            initialOffsetX = { it / 3 },
            animationSpec = tween(300)
        ) + fadeIn(animationSpec = tween(300)),
        exit = slideOutHorizontally(
            targetOffsetX = { -it / 3 },
            animationSpec = tween(200)
        ) + fadeOut(animationSpec = tween(200)),
        modifier = modifier,
        content = content
    )
}

@Composable
fun FadeTransition(
    targetState: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = targetState,
        enter = fadeIn(animationSpec = tween(400)),
        exit = fadeOut(animationSpec = tween(200)),
        modifier = modifier,
        content = content
    )
}
