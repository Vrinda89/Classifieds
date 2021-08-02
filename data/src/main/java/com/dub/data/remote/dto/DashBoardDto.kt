package com.dub.data.remote.dto

import com.google.gson.annotations.SerializedName

sealed class DashBoardDto {
    data class DashBoard(
        @SerializedName("results") val results: ArrayList<Product>? = arrayListOf()
    )

    data class Product(
        @SerializedName("created_at") val created_at: String? = null,
        @SerializedName("price") val price: String? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("uid") val uid: String? = null,
        @SerializedName("image_ids") val image_ids: ArrayList<String>? = arrayListOf(),
        @SerializedName("image_urls") val image_urls: ArrayList<String>? = arrayListOf(),
        @SerializedName("image_urls_thumbnails") val image_urls_thumbnails: ArrayList<String>? = arrayListOf(),
    )
}