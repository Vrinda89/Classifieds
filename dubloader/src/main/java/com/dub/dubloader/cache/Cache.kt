package com.dub.dubloader.cache

import com.dub.dubloader.model.CacheFile

interface Cache {
    fun get(url: String, type: Int): CacheFile?
    fun put(url: String, type: Int, data: ByteArray)
}