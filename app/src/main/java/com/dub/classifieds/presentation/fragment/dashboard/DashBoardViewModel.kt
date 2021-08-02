package com.dub.classifieds.presentation.fragment.dashboard

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.dub.classifieds.BR
import com.dub.classifieds.R
import com.dub.classifieds.presentation.fragment.base.BaseViewModel
import com.dub.classifieds.presentation.listeners.OnItemClickListener
import com.dub.classifieds.utils.SingleLiveEvent
import com.dub.domain.common.ResultState
import com.dub.domain.entity.DashBoardEntity
import com.dub.domain.usecases.dashboard.DashBoardUseCase
import me.tatarka.bindingcollectionadapter2.ItemBinding

class DashBoardViewModel(private val dashBoardUseCase: DashBoardUseCase) : BaseViewModel() {

    val onItemClickEvent = SingleLiveEvent<DashBoardEntity.Product>()
    val noData = ObservableField(false)

    var items = ObservableArrayList<DashBoardEntity.Product>()
    val itemBinding: ItemBinding<DashBoardEntity.Product> =
        ItemBinding.of<DashBoardEntity.Product>(BR.itemViewModel, R.layout.item_view_classifieds)
            .bindExtra(BR.listener, object : OnItemClickListener {
                override fun onItemClicked(item: Any) {
                    if (item is DashBoardEntity.Product)
                        onItemClickEvent.value = item
                }
            })

    init {
        loadDashBoard()
    }

    private fun loadDashBoard() {
        showLoading(true)
        dashBoardUseCase.getDashBoardData().track {
            showLoading(false)
            when (it) {
                is ResultState.Success<DashBoardEntity.DashBoard> -> {
                    it.data.results?.takeIf { it.isNotEmpty() }?.let { productList ->
                        noData.set(false)
                        items.clear()
                        items.addAll(productList)
                    } ?: run {
                        items.clear()
                        noData.set(true)
                    }
                }
                is ResultState.Error -> {
                    onErrorMessage.value = "Something went wrong!!"
                }
            }
        }
    }
}