package com.vatsal.guidomia.util

import com.vatsal.guidomia.R

fun String?.getImageDrawable(): Int =
    when (this) {
        "Range Rover" -> R.drawable.range_rover
        "Roadster" -> R.drawable.alpine_roadster
        "3300i" -> R.drawable.bmw_330i
        "GLE coupe" -> R.drawable.mercedez_benz_glc
        else -> R.drawable.alpine_roadster
    }

fun Int?.convertToThousands(): Int = this?.div(1000) ?: 0