package com.dub.data.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toFormattedDate(
    format: String = "yyyy-MM-dd HH:mm:ss.SSS",
    outFormat: String = "dd.MM.yyyy HH:mm"
): String {
    return kotlin.runCatching {
        val parser = SimpleDateFormat(format, Locale.getDefault())
        val formatter = SimpleDateFormat(outFormat, Locale.getDefault())
        parser.parse(this)?.let {
            return formatter.format(it)
        } ?: this
    }.getOrNull() ?: this
}

fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
