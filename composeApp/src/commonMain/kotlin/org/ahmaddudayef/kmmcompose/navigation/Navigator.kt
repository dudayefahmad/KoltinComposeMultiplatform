package org.ahmaddudayef.kmmcompose.navigation

import androidx.compose.runtime.staticCompositionLocalOf


interface Navigator {
    fun navigate(navTarget: NavTarget)
    fun back()
}

val LocalNavigator = staticCompositionLocalOf<Navigator> { error("navigator not provided") }