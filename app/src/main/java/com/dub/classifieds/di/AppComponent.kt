package com.dub.classifieds.di

import com.dub.classifieds.di.module.ViewModelModule
import com.dub.data.module.ApiModule
import com.dub.data.module.RepositoryModule
import com.dub.data.module.RetrofitModule
import com.dub.data.module.UseCaseModule

object AppComponent {

    fun loadAllModules() = listOf(
        ApiModule.modules,
        RepositoryModule.modules,
        UseCaseModule.modules,
        RetrofitModule.modules,
        ViewModelModule.modules
    )
}