package com.ianpedraza.coffee4coders.models

import com.ianpedraza.coffee4coders.utils.EMPTY_STRING

data class ProductModel(
    val id: Int = 0,
    val name: String = EMPTY_STRING,
    val summary: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val price: Double = 0.0,
    val currency: String = EMPTY_STRING,
    val countryISO: String = EMPTY_STRING,
) {

}