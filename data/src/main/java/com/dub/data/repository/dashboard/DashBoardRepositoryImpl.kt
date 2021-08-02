package com.dub.data.repository.dashboard

import com.dub.data.mapper.dtotoentity.map
import com.dub.data.remote.api.DashBoardApi
import com.dub.domain.common.ResultState
import com.dub.domain.entity.DashBoardEntity
import com.dub.domain.repository.dashboard.DashBoardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DashBoardRepositoryImpl(val api: DashBoardApi) : DashBoardRepository {

    override fun getDashBoardData(): Flow<ResultState<DashBoardEntity.DashBoard>> = flow {
        emit(
            try {
                ResultState.Success(api.loadDashBoard().map())
            } catch (ex: Throwable) {
                ResultState.Error("")
            }
        )
    }

}