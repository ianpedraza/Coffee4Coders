package com.ianpedraza.coffee4coders.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ianpedraza.coffee4coders.R
import com.ianpedraza.coffee4coders.ui.theme.Coffee4CodersTheme
import com.ianpedraza.coffee4coders.utils.EMPTY_STRING
import com.ianpedraza.coffee4coders.utils.UnitCallback

@Composable
fun CustomAppBar(
    title: String = EMPTY_STRING,
    navigationIcon: ImageVector? = null,
    onNavigationAction: UnitCallback = {}
) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = navigationIcon?.let {
            {
                IconButton(onClick = onNavigationAction) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = stringResource(R.string.cd_navigation_icon),
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CustomAppBarPreview() {
    Coffee4CodersTheme {
        CustomAppBar(
            title = stringResource(R.string.app_name)
        )
    }
}