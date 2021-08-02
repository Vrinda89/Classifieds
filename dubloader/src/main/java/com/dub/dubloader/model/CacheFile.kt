package com.dub.dubloader.model

class CacheFile(private val imageBytes: ByteArray, val type: Int) {
    fun getImageBytes(): ByteArray {
        return imageBytes
    }
}