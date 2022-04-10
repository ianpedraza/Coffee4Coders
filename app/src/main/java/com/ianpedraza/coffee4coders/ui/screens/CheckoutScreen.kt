package com.ianpedraza.coffee4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ianpedraza.coffee4coders.R
import com.ianpedraza.coffee4coders.network.MockDataProvider
import com.ianpedraza.coffee4coders.ui.components.*
import com.ianpedraza.coffee4coders.ui.theme.Coffee4CodersTheme
import com.ianpedraza.coffee4coders.utils.EMPTY_STRING
import com.ianpedraza.coffee4coders.utils.SHIPMENT_PRICE
import com.ianpedraza.coffee4coders.utils.Screen

@Composable
fun CheckoutScreen(
    navController: NavController,
    productId: Int,
) {
    var name by remember { mutableStateOf(EMPTY_STRING) }

    var email by remember { mutableStateOf(EMPTY_STRING) }

    var phone by remember { mutableStateOf(EMPTY_STRING) }

    var address by remember { mutableStateOf(EMPTY_STRING) }

    var city by remember { mutableStateOf(EMPTY_STRING) }

    var showAlert by remember { mutableStateOf(false) }

    val cities = MockDataProvider.listOfCities()
    val product = MockDataProvider.getProductById(productId)

    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                val route = Screen.Detail.createRoute(productId)

                navController.navigate(route) {
                    popUpTo(route)
                }
            }
        },
        content = {
            if (product == null) {
                Text(stringResource(R.string.e_invalid_product))
            } else {
                Alert(
                    title = stringResource(R.string.checkout_alert_title),
                    message = stringResource(R.string.checkout_alert_message),
                    showAlert = showAlert
                ) {
                    navController.navigate(Screen.Feed.route) {
                        launchSingleTop = true
                        popUpTo(Screen.Feed.route)
                    }
                }
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    ProductCard(
                        name = product.name,
                        summary = product.summary,
                        price = product.price,
                        currency = product.currency,
                        countryIso = product.countryISO
                    ) {

                    }
                    Box(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        CustomTextField(
                            value = name,
                            placeholder = stringResource(R.string.field_full_name)
                        ) { value ->
                            name = value
                        }
                        Box(modifier = Modifier.height(16.dp))
                        CustomTextField(
                            value = email,
                            placeholder = stringResource(R.string.field_email)
                        ) { value ->
                            email = value
                        }
                        Box(modifier = Modifier.height(16.dp))
                        CustomTextField(
                            value = phone,
                            placeholder = stringResource(R.string.field_phone_number)
                        ) { value ->
                            phone = value
                        }
                        Box(modifier = Modifier.height(16.dp))
                        CustomTextField(
                            value = address,
                            placeholder = stringResource(R.string.field_address)
                        ) { value ->
                            address = value
                        }
                        Box(modifier = Modifier.height(16.dp))
                        DropdownTextField(
                            cities,
                            value = city,
                            placeholder = stringResource(R.string.field_cities)
                        ) { value ->
                            city = value
                        }
                        Box(modifier = Modifier.height(16.dp))
                        Column {
                            Row {
                                Text(
                                    text = stringResource(R.string.checkout_subtotal),
                                    style = MaterialTheme.typography.caption
                                )
                                Text(
                                    text = "${product.price} ${product.currency}",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            Row {
                                Text(
                                    text = stringResource(R.string.checkout_shipment),
                                    style = MaterialTheme.typography.caption
                                )
                                Text(
                                    text = "$SHIPMENT_PRICE ${product.currency}",
                                    textAlign = TextAlign.End,
                                    style = MaterialTheme.typography.body2,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                        Box(modifier = Modifier.height(16.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "${product.price + SHIPMENT_PRICE} ${product.currency}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.h5,
                            )
                            CustomButton(stringResource(R.string.checkout_place_order)) {
                                showAlert = true
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()

    Coffee4CodersTheme {
        CheckoutScreen(navController, 0)
    }
}