package com.vatsal.guidomia.model

/**
 *  Data class for CarItem.
 *  @property consList - List of String
 *  @property customerPrice - customer price.
 *  @property make -  String value of the car maker.
 *  @property marketPrice - market price.
 *  @property model - Model of the car.
 *  @property prosList - List of string.
 *  @property rating - Rating of the car.
 */
data class CarsItem(
    val consList: List<String?>? = null,
    val customerPrice: Double? = null,
    val make: String? = null,
    val marketPrice: Double? = null,
    val model: String? = null,
    val prosList: List<String?>? = null,
    val rating: Int? = null
)