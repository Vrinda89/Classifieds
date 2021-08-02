package com.dub.classifieds.presentation.fragment.details

import android.os.Bundle
import android.view.View
import com.dub.classifieds.BR
import com.dub.classifieds.R
import com.dub.classifieds.databinding.FragmentDetailsBinding
import com.dub.classifieds.presentation.fragment.base.BaseFragment
import com.dub.domain.entity.DashBoardEntity

class DetailsFragment :
    BaseFragment<DetailsViewModel, FragmentDetailsBinding>(DetailsViewModel::class) {

    override val layoutRes: Int
        get() = R.layout.fragment_details

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val product: DashBoardEntity.Product =
                it.getSerializable("product") as DashBoardEntity.Product
            viewModel.items.set(product)
        }
    }
}