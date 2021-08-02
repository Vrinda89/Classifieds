package com.dub.dubloader.listener

interface ImageLoaderCallback {
    fun onImageReceived(`is`: ByteArray?, type: Int, url: String)
    fun onFailed(url: String)
}