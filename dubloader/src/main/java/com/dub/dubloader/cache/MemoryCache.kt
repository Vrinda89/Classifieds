package com.dub.dubloader.cache

import android.util.LruCache
import com.dub.dubloader.model.CacheFile

/**
 *
 */
class MemoryCache(capacity: Int) : Cache {
    private var cache // to store downloaded info in cache to  reuse
            : LruCache<String, CacheFile?>? = null
    private val capacity: Int

    /**
     * @param percentageOfMemoryForCache
     * @return cacheSize
     */
    private fun calculateCacheSize(percentageOfMemoryForCache: Int): Int {
        val runtime = Runtime.getRuntime()
        val calculatedSize = (runtime.maxMemory() * percentageOfMemoryForCache / 100).toInt()
        return Math.min(calculatedSize, MAX_CACHE_SIZE)
    }

    /**
     * clear cache  if its not empty otherwise initializing with allotted percentage of memory
     */
    private fun reset() {
        cache?.evictAll() ?: run {
            cache = LruCache(capacity)
        }
    }

    /**
     * @param url
     * @param type
     * @return Cache File : Checking whether a url is already in cache if already there return the CacheFile from cache
     */
    override fun get(url: String, type: Int): CacheFile? {
        return cache?.get(url)?.takeIf { it.type == type }
    }

    /**
     * @param url
     * @param type
     * @param data Writes  the data if its not in the cache
     */
    override fun put(url: String, type: Int, data: ByteArray) {
        cache?.get(url)?.takeIf { it.type == type } ?: kotlin.run {
            cache?.put(url, CacheFile(data, type))
        }
    }

    companion object {
        private const val MAX_CACHE_SIZE = 16 * 1024 * 1024
    }

    init {
        this.capacity = calculateCacheSize(capacity)
        reset()
    }
}