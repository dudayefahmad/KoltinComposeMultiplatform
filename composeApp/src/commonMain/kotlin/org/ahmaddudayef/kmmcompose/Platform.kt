package org.ahmaddudayef.kmmcompose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform