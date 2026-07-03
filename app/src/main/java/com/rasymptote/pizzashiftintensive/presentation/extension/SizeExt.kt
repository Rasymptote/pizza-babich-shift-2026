package com.rasymptote.pizzashiftintensive.presentation.extension

import androidx.annotation.StringRes
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.Size

@StringRes
fun Size.titleRes(): Int = when (this) {
    Size.SMALL -> R.string.size_small
    Size.MEDIUM -> R.string.size_medium
    Size.LARGE -> R.string.size_large
}