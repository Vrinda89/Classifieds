package com.dub.classifieds.presentation.fragment.details

import androidx.databinding.ObservableField
import com.dub.classifieds.presentation.fragment.base.BaseViewModel
import com.dub.domain.entity.DashBoardEntity

class DetailsViewModel : BaseViewModel() {
    var items = ObservableField<DashBoardEntity.Product>()
}