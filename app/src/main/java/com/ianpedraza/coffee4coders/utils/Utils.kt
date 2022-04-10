package com.ianpedraza.coffee4coders.utils

import androidx.compose.runtime.Composable

typealias UnitCallback = () -> Unit
typealias SimpleCallback<T> = (T) -> Unit
typealias ComposableFunction = @Composable () -> Unit

const val EMPTY_STRING = ""
const val SHIPMENT_PRICE = 10.0