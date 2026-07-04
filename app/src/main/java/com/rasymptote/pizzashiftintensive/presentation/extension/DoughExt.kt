package com.rasymptote.pizzashiftintensive.presentation.extension

import androidx.annotation.StringRes
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.Dough

@StringRes
fun Dough.titleRes(): Int = when (this) {
    Dough.THIN -> R.string.dough_thin
    Dough.THICK -> R.string.dough_thick
}