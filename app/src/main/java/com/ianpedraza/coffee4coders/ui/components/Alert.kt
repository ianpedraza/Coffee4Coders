package com.ianpedraza.coffee4coders.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.ianpedraza.coffee4coders.R
import com.ianpedraza.coffee4coders.ui.theme.Coffee4CodersTheme
import com.ianpedraza.coffee4coders.utils.EMPTY_STRING
import com.ianpedraza.coffee4coders.utils.UnitCallback

@Composable
fun Alert(
    title: String = EMPTY_STRING,
    message: String,
    showAlert: Boolean = false,
    onClose: UnitCallback
) {
    if (showAlert) {
        AlertDialog(
            onDismissRequest = onClose,
            title = {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Black
                    )
                )
            },
            text = {
                Text(
                    text = message
                )
            },
            confirmButton = {
                Button(onClick = onClose) {
                    Text(stringResource(R.string.ok))
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertPreview() {
    Coffee4CodersTheme {
        Alert(
            message = "Preview Message",
            showAlert = true
        ) {

        }
    }
}