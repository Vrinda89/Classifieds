package com.dub.classifieds.presentation.fragment.dashboard

import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dub.classifieds.BR
import com.dub.classifieds.R
import com.dub.classifieds.presentation.fragment.base.BaseFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DashBoardFragment :
    BaseFragment<DashBoardViewModel, ViewDataBinding>(DashBoardViewModel::class) {

    override val layoutRes: Int
        get() = R.layout.fragment_dashboard
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun subscribeNavigationEvents() {
        super.subscribeNavigationEvents()
        viewModel.onItemClickEvent.observe(viewLifecycleOwner, {
            findNavController().navigate(
                R.id.action_FirstFragment_to_SecondFragment, bundleOf(
                    Pair("product", it)
                )
            )
        })

    }


}