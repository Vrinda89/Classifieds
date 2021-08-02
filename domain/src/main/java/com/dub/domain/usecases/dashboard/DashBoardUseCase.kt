package com.dub.domain.usecases.dashboard

import com.dub.domain.common.ResultState
import com.dub.domain.entity.DashBoardEntity
import com.dub.domain.usecases.BaseUseCase
import kotlinx.coroutines.flow.Flow

interface DashBoardUseCase : BaseUseCase {
    fun getDashBoardData(): Flow<ResultState<DashBoardEntity.DashBoard>>
}