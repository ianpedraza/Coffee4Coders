package com.ianpedraza.coffee4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ianpedraza.coffee4coders.R
import com.ianpedraza.coffee4coders.network.MockDataProvider
import com.ianpedraza.coffee4coders.ui.theme.Coffee4CodersTheme
import com.ianpedraza.coffee4coders.ui.theme.PlatziBlue
import com.ianpedraza.coffee4coders.ui.theme.PlatziGreen
import com.ianpedraza.coffee4coders.utils.UnitCallback

enum class CountryISO(
    val iso: String,
    val backgroundImage: Int,
    val countryFlag: Int,
    val surfaceColor: Color,
) {
    COL("COL", R.drawable.co, R.drawable.flagco, PlatziBlue),
    BRA("BRA", R.drawable.br, R.drawable.flagbr, PlatziGreen),
    CRI("CRI", R.drawable.ri, R.drawable.flagri, PlatziGreen),
    NIC("NIC", R.drawable.ni, R.drawable.flagni, PlatziBlue)
}

@Composable
fun ProductCard(
    name: String,
    summary: String,
    price: Double,
    currency: String,
    countryIso: String,
    onSelect: UnitCallback,
) {
    val country = CountryISO.valueOf(countryIso)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onSelect() }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small,
    ) {
        Image(
            painter = painterResource(id = country.backgroundImage),
            contentDescription = stringResource(R.string.cd_product_card_bg)
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.surfaceColor.copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = summary,
                    style = MaterialTheme.typography.body1
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Row {
                        Image(
                            painter = painterResource(country.countryFlag),
                            contentDescription = stringResource(R.string.cd_product_flag),
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "$$price $currency",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    val product = MockDataProvider.getProductById(0)

    Coffee4CodersTheme {
        ProductCard(
            name = product!!.name,
            summary = product.summary,
            price = product.price,
            currency = product.currency,
            countryIso = product.countryISO
        ) {

        }
    }
}