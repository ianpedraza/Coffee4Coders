package com.ianpedraza.coffee4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.ianpedraza.coffee4coders.utils.Screen

@Composable
fun DetailScreen(
    navController: NavController,
    productId: Int,
) {
    val product = MockDataProvider.getProductById(productId)

    val country = if (product != null) {
        CountryISO.valueOf(product.countryISO)
    } else {
        null
    }

    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate(Screen.Feed.route) {
                    popUpTo(Screen.Feed.route)
                }
            }
        },
        content = {
            if (product == null) {
                Text(stringResource(R.string.e_invalid_product))
            } else {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    ) {
                        Image(
                            painter = painterResource(country!!.backgroundImage),
                            contentDescription = stringResource(R.string.cd_product_card_bg),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        TitleText(
                            title = product.name
                        )
                        Text(
                            text = product.summary,
                            style = MaterialTheme.typography.caption
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        BodyText(
                            body = product.description
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "${product.price} ${product.currency}",
                                style = MaterialTheme.typography.h5,
                                textAlign = TextAlign.End
                            )
                            CustomButton(label = stringResource(R.string.detail_add_to_cart)) {
                                navController.navigate(Screen.Checkout.createRoute(productId)) {
                                    launchSingleTop = true
                                }
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
fun DetailScreenPreview() {
    val navController = rememberNavController()

    Coffee4CodersTheme {
        DetailScreen(navController, 0)
    }
}