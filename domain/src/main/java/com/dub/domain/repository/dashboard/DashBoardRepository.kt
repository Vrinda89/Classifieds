package com.dub.domain.repository.dashboard

import com.dub.domain.common.ResultState
import com.dub.domain.entity.DashBoardEntity
import com.dub.domain.repository.BaseRepository
import kotlinx.coroutines.flow.Flow

interface DashBoardRepository :BaseRepository{
    fun getDashBoardData(): Flow<ResultState<DashBoardEntity.DashBoard>>
}