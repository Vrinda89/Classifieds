package com.dub.dubloader.utils

import android.text.TextUtils
import android.util.Patterns

object MUtil {
    /**
     * @param url
     * @return true if url is a valid one otherwise false.
     */
    fun isValidURL(url: String?): Boolean {
        return url?.let { !TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches() }
            ?: false
    }
}