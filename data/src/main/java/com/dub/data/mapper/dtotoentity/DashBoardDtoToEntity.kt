package com.dub.data.mapper.dtotoentity

import com.dub.data.remote.dto.DashBoardDto
import com.dub.data.utils.capitalizeWords
import com.dub.data.utils.toFormattedDate
import com.dub.domain.entity.DashBoardEntity

fun DashBoardDto.DashBoard.map() = DashBoardEntity.DashBoard(results = results?.mapList())

fun ArrayList<DashBoardDto.Product>.mapList(): ArrayList<DashBoardEntity.Product> {
    return this.mapTo(arrayListOf(), { it.map() })
}

fun DashBoardDto.Product.map() = DashBoardEntity.Product(
    created_at?.toFormattedDate(),
    price,
    name?.capitalizeWords(),
    uid,
    image_ids,
    image_urls?.firstOrNull(),
    image_urls_thumbnails?.firstOrNull()
)