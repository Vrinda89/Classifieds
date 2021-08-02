package com.dub.dubloader.downloader

import com.dub.dubloader.cache.GetCache
import com.dub.dubloader.listener.ImageLoaderCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageDownloader internal constructor(
    private val sm: StreamManager,
    private val callback: ImageLoaderCallback
) : GetCache {

    override fun fetchByte(url: String): Boolean {
        GlobalScope.launch {
            val imageBytes = getImageBytes(url)
            withContext(Dispatchers.Main) {
                imageBytes?.let {
                    callback.onImageReceived(it, 0, url)
                } ?: callback.onFailed(url)
            }
        }
        return false
    }

    private suspend fun getImageBytes(url: String): ByteArray? {
        return withContext(Dispatchers.IO) {
            return@withContext kotlin.runCatching {
                sm.retrieveInputStream(url)
            }.getOrNull()
        }
    }
}