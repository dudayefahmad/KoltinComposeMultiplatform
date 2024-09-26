package org.ahmaddudayef.kmmcompose.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

object Routers {
    const val SCREEN_1 = "SCREEN_1"
    const val SCREEN_2 = "SCREEN_2/{name}"
    const val SCREEN_3 = "SCREEN_3"
}

val LocalNavigationController =
    staticCompositionLocalOf<NavHostController> { error("nav host not provided") }