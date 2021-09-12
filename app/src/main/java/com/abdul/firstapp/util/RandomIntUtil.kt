package com.abdul.firstapp.util

import java.util.concurrent.atomic.AtomicInteger

class RandomIntUtil {
    private val seed = AtomicInteger()

    public fun getRandomInt() = seed.getAndIncrement()
}