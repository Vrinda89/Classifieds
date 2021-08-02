package com.dub.dubloader.cache

interface PutCache {
    fun put(url: String, type: Int, data: ByteArray)
}