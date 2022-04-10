package com.ianpedraza.coffee4coders.utils

sealed class Screen(val route: String) {
    object Feed: Screen("feed")
    object Detail: Screen("detail/{productId}") {
        fun createRoute(productId: Int) = "detail/$productId"
    }
    object Checkout: Screen("checkout/{productId}") {
        fun createRoute(productId: Int) = "checkout/$productId"
    }
}