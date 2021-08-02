package com.dub.data.module

import com.dub.data.usecase.dashboard.DashBoardUseCaseImpl
import com.dub.domain.repository.dashboard.DashBoardRepository
import com.dub.domain.usecases.dashboard.DashBoardUseCase
import org.koin.dsl.module

object UseCaseModule {
    val modules =
        module { single<DashBoardUseCase> { DashBoardUseCaseImpl(repository = get() as DashBoardRepository) } }

}