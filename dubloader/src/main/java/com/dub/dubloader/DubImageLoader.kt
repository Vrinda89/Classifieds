package com.dub.dubloader

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.dub.dubloader.cache.CacheManager
import com.dub.dubloader.cache.MemoryCache
import com.dub.dubloader.downloader.ImageDownloader
import com.dub.dubloader.downloader.StreamManager
import com.dub.dubloader.listener.ImageLoaderCallback
import com.dub.dubloader.utils.MUtil
import java.util.*

object DubImageLoader : ImageLoaderCallback {

    private const val PERCENTAGE_OF_MEMORY_FOR_CACHING = 15

    private var downloader = ImageDownloader(StreamManager(), this)
    private var cacheRetriever = CacheManager(MemoryCache(PERCENTAGE_OF_MEMORY_FOR_CACHING), this)

    private val errorPlaceHolder = hashMapOf<String, Drawable>()
    private val viewHandler =
        hashMapOf<String?, List<ImageView>?>() //To store data if url is repeated and not fetched at least one response for the same.


    /**
     * Checks if image is already cached using url as key
     * If already cached return image bytes and load in imageview
     * else download and cache image bytes with url as key then load in imageview
     */
    fun loadImage(
        url: String,
        view: ImageView,
        placeHolder: Drawable?,
        errorDrawable: Drawable?
    ) {
        if (!MUtil.isValidURL(url)) {
            return
        }
        view.setImageDrawable(placeHolder)

        viewHolder(view, url)
        if (cacheRetriever.fetchByte(url)) {
            return
        }
        errorDrawable?.let {
            errorPlaceHolder[url] = errorDrawable
        }
        downloader.fetchByte(url)
    }

    private fun viewHolder(view: ImageView, id: String) {
        val imageViews: MutableList<ImageView> = ArrayList()
        imageViews.add(view)
        val list = viewHandler[id]
        if (list != null) {
            imageViews.addAll(list)
        }
        viewHandler[id] = imageViews
    }

    override fun onImageReceived(`is`: ByteArray?, type: Int, url: String) {
        `is`?.let {
            BitmapFactory.decodeByteArray(it, 0, it.size)?.let { bitmap ->
                cacheRetriever.put(url, type, `is`)
                val viewList = viewHandler[url]
                if (viewList != null) {
                    for (imageView in viewList) imageView.setImageBitmap(bitmap)
                    viewHandler.remove(url)
                }
            }
        }
    }


    /**
     * On Failure sets the error placeholder
     */
    override fun onFailed(url: String) {
        viewHandler[url]?.let { viewList ->
            errorPlaceHolder[url]?.let { bitmap ->
                for (imageView in viewList) {
                    imageView.setImageDrawable(bitmap)
                }
                viewHandler.remove(url)
            }
        }
    }
}