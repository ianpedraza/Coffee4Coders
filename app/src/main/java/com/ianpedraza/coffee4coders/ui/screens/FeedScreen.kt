package com.ianpedraza.coffee4coders.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
fun FeedScreen(
    navController: NavController
) {
    val products = MockDataProvider.listOfProducts()

    Coffee4CodersTheme {
        Scaffold(
            topBar = {
                CustomAppBar(
                    title = stringResource(R.string.app_name)
                )
            },
            content = {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                TitleText(title = stringResource(R.string.fee_screen_title))
                                BodyText(body = stringResource(R.string.fee_screen_description))
                            }
                        }
                        items(products) { product ->
                            ProductCard(
                                name = product.name,
                                summary = product.summary,
                                price = product.price,
                                currency = product.currency,
                                countryIso = product.countryISO,
                            ) {
                                navController.navigate(Screen.Detail.createRoute(product.id)) {
                                    // If there's another screen like this, don't open a new one
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun FeedScreenPreviewDark() {
    val navController = rememberNavController()
    FeedScreen(navController)
}
