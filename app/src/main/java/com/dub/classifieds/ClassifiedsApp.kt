package com.dub.classifieds

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.dub.classifieds.di.AppComponent.loadAllModules
import com.dub.classifieds.di.module.ViewModelModule
import com.dub.data.module.ApiModule
import com.dub.data.module.RepositoryModule
import com.dub.data.module.RetrofitModule
import com.dub.data.module.UseCaseModule
import org.koin.core.context.startKoin

class ClassifiedsApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(loadAllModules()) }
    }

    private fun loadAllModules() = listOf(
        ApiModule.modules,
        RepositoryModule.modules,
        UseCaseModule.modules,
        RetrofitModule.modules,
        ViewModelModule.modules
    )

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}