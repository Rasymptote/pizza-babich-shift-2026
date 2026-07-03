package com.rasymptote.pizzashiftintensive.presentation.extension

fun String.capitalizeFirst(): String =
    replaceFirstChar {
        if (it.isLowerCase()) it.titlecase() else it.toString()
    }