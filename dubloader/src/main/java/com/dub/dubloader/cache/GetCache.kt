package com.dub.dubloader.cache

interface GetCache {
    fun fetchByte(url: String): Boolean
}