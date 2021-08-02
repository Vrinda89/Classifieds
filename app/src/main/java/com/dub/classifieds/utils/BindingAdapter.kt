package com.dub.classifieds.utils

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.dub.classifieds.R
import com.dub.data.utils.capitalizeWords
import com.dub.dubloader.DubImageLoader

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: AppCompatImageView, url: String?) {
        url?.let {
            DubImageLoader.loadImage(
                it,
                imageView,
                ContextCompat.getDrawable(imageView.context, R.drawable.ic_placeholder),
                ContextCompat.getDrawable(imageView.context, R.drawable.ic_error_placeholder)
            )
        }
    }

    @JvmStatic
    @BindingAdapter("format")
    fun setFormatter(textView: TextView, text: String?) {
        textView.text = text?.capitalizeWords()
    }

}