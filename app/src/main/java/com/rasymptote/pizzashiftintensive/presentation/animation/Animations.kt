package com.rasymptote.pizzashiftintensive.presentation.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.animation.togetherWith
import androidx.compose.ui.unit.IntOffset
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.scene.Scene
import androidx.navigationevent.NavigationEvent

private const val FADE_DURATION = 200
private const val SLIDE_DURATION = 300
private const val OFFSET_PERCENT = 0.15f

private val FADE_IN =
    fadeIn(
        animationSpec = tween(FADE_DURATION),
        initialAlpha = 0.5f
    )

private val FADE_OUT =
    fadeOut(
        animationSpec = tween(FADE_DURATION)
    )

private val SLIDE_IN_RIGHT_TO_LEFT =
    slideIn(
        animationSpec = tween(SLIDE_DURATION)
    ) {
        IntOffset(
            x = (it.width * OFFSET_PERCENT).toInt(),
            y = 0
        )
    }

private val SLIDE_OUT_RIGHT_TO_LEFT =
    slideOut(
        animationSpec = tween(SLIDE_DURATION)
    ) {
        IntOffset(
            x = -(it.width * OFFSET_PERCENT).toInt(),
            y = 0
        )
    }

private val SLIDE_IN_LEFT_TO_RIGHT =
    slideIn(
        animationSpec = tween(SLIDE_DURATION)
    ) {
        IntOffset(
            x = -(it.width * OFFSET_PERCENT).toInt(),
            y = 0
        )
    }

private val SLIDE_OUT_LEFT_TO_RIGHT =
    slideOut(
        animationSpec = tween(SLIDE_DURATION)
    ) {
        IntOffset(
            x = (it.width * OFFSET_PERCENT).toInt(),
            y = 0
        )
    }

val ENTER_TRANSITION:
        AnimatedContentTransitionScope<Scene<NavKey>>.() -> ContentTransform = {
    (FADE_IN + SLIDE_IN_RIGHT_TO_LEFT)
        .togetherWith(FADE_OUT + SLIDE_OUT_RIGHT_TO_LEFT)
}

val EXIT_TRANSITION:
        AnimatedContentTransitionScope<Scene<NavKey>>.() -> ContentTransform = {
    (FADE_IN + SLIDE_IN_LEFT_TO_RIGHT)
        .togetherWith(FADE_OUT + SLIDE_OUT_LEFT_TO_RIGHT)
}

val PREDICTIVE_EXIT_TRANSITION:
        AnimatedContentTransitionScope<Scene<NavKey>>.(@NavigationEvent.SwipeEdge Int) -> ContentTransform =
{ swipeEdge ->
    if (swipeEdge == NavigationEvent.EDGE_RIGHT) {
        (FADE_IN + SLIDE_IN_RIGHT_TO_LEFT).togetherWith(FADE_OUT + SLIDE_OUT_RIGHT_TO_LEFT)
    } else {
        (FADE_IN + SLIDE_IN_LEFT_TO_RIGHT).togetherWith(FADE_OUT + SLIDE_OUT_LEFT_TO_RIGHT)
    }
}