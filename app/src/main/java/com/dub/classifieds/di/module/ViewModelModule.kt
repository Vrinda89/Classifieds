package com.dub.classifieds.di.module

import com.dub.classifieds.presentation.fragment.dashboard.DashBoardViewModel
import com.dub.classifieds.presentation.fragment.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

object ViewModelModule {

    val modules = org.koin.dsl.module {
        viewModel {
            DashBoardViewModel(get())
        }
        viewModel {
            DetailsViewModel()
        }
    }
}