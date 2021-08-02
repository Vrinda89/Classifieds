package com.dub.domain.entity

import java.io.Serializable

sealed class DashBoardEntity {
    data class DashBoard(
        val results: ArrayList<Product>? = arrayListOf()
    )

    data class Product(
        val created_at: String? = null,
        val price: String? = null,
        val name: String? = null,
        val uid: String? = null,
        val image_ids: ArrayList<String>? = arrayListOf(),
        val image_url: String? = null,
        val image_urls_thumbnail: String? = null,
    ) : Serializable
}