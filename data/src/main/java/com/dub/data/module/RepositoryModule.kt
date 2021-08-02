package com.dub.data.module

import com.dub.data.remote.api.DashBoardApi
import com.dub.data.repository.dashboard.DashBoardRepositoryImpl
import com.dub.domain.repository.dashboard.DashBoardRepository
import org.koin.dsl.module

object RepositoryModule {

    val modules =
        module { single<DashBoardRepository> { DashBoardRepositoryImpl(api = get() as DashBoardApi) } }
}