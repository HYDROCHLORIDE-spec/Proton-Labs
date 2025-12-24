package com.example.protondev

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform