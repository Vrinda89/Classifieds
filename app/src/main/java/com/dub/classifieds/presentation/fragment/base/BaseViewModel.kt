package com.dub.classifieds.presentation.fragment.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dub.classifieds.utils.SingleLiveEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    val showLoader = ObservableField(false)
    val onErrorMessage = SingleLiveEvent<String>()

    fun showLoading(show: Boolean) {
        showLoader.set(show)
    }

    fun <T : Any> Flow<T>.track(action: (value: T) -> Unit) =
        viewModelScope.launch {
            collect {
                action(it)
            }
        }
}