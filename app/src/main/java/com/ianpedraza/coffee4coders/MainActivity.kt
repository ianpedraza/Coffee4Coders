package com.ianpedraza.coffee4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ianpedraza.coffee4coders.ui.components.CountryISO
import com.ianpedraza.coffee4coders.ui.screens.CheckoutScreen
import com.ianpedraza.coffee4coders.ui.screens.DetailScreen
import com.ianpedraza.coffee4coders.ui.screens.FeedScreen
import com.ianpedraza.coffee4coders.ui.theme.Coffee4CodersTheme
import com.ianpedraza.coffee4coders.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavigationHost() }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    Coffee4CodersTheme {
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Feed.route
            ) {
                composable(route = Screen.Feed.route) {
                    FeedScreen(navController)
                }
                composable(route = Screen.Detail.route) { backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId") ?: "0"
                    val productId = productIdString.toInt()
                    DetailScreen(navController, productId)
                }
                composable(route = Screen.Checkout.route) { backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId") ?: "0"
                    val productId = productIdString.toInt()
                    CheckoutScreen(navController, productId)
                }
            }
        }
    }
}