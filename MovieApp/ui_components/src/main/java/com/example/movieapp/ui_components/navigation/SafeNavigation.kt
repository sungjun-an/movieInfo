package com.example.movieapp.ui_components.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections

fun NavController.safeNavigate(url: String) {
    currentDestination?.run {
        NavDeepLinkRequest.Builder
            .fromUri(url.toUri())
            .build()
    }
}