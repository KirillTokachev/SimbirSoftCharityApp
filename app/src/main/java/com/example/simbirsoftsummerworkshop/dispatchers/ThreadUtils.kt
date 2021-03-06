package com.example.simbirsoftsummerworkshop.dispatchers

interface ThreadUtils {
    fun sleep(millis: Long)

    class Default : ThreadUtils {
        override fun sleep(millis: Long) {
            Thread.sleep(millis)
        }
    }
}
