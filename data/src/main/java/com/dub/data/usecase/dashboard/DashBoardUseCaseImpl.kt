package com.dub.data.usecase.dashboard

import com.dub.domain.common.ResultState
import com.dub.domain.entity.DashBoardEntity
import com.dub.domain.repository.dashboard.DashBoardRepository
import com.dub.domain.usecases.dashboard.DashBoardUseCase
import kotlinx.coroutines.flow.Flow

class DashBoardUseCaseImpl(val repository: DashBoardRepository) : DashBoardUseCase {
    override fun getDashBoardData(): Flow<ResultState<DashBoardEntity.DashBoard>> {
        return repository.getDashBoardData()
    }
}