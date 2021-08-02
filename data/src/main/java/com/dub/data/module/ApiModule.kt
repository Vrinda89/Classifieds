package com.dub.data.module

import com.dub.data.remote.api.DashBoardApi
import org.koin.dsl.module
import retrofit2.Retrofit


object ApiModule {
    val modules= module {
        single<DashBoardApi> { (get() as Retrofit).create(DashBoardApi::class.java) }
    }
}