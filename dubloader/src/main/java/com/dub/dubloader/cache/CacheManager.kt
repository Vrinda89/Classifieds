package com.dub.dubloader.cache

import com.dub.dubloader.listener.ImageLoaderCallback

class CacheManager(
    private val memoryCache: Cache?,
    private val callback: ImageLoaderCallback
) : GetCache, PutCache {

    override fun fetchByte(url: String): Boolean {
        val cacheFile = memoryCache?.get(url, 0)
        cacheFile?.let {
            callback.onImageReceived(cacheFile.getImageBytes(), cacheFile.type, url)
            return true
        }
        return false
    }

    override fun put(url: String, type: Int, data: ByteArray) {
        memoryCache?.put(url, type, data)
    }
}