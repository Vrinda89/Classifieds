package com.dub.data.remote.api

import com.dub.data.remote.dto.DashBoardDto
import retrofit2.http.GET

interface DashBoardApi {
    @GET("default/dynamodb-writer")
    suspend fun loadDashBoard(): DashBoardDto.DashBoard
}