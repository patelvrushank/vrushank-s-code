package com.vatsal.guidomia.util

import com.vatsal.guidomia.R

/**
 * Fun to map the image drawable with car.
 */
fun String?.getImageDrawable(): Int =
    when (this) {
        "Range Rover" -> R.drawable.range_rover
        "Roadster" -> R.drawable.alpine_roadster
        "3300i" -> R.drawable.bmw_330i
        "GLE coupe" -> R.drawable.mercedez_benz_glc
        else -> R.drawable.alpine_roadster
    }

/**
 * Fun to convert price into thousands.
 */
fun Int?.convertToThousands(): Int = this?.div(1000) ?: 0