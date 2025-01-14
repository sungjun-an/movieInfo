package com.example.movieapp.ui_components.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movieapp.ui_components.theme.Paddings
import com.example.movieapp.ui_components.theme.colorSchema
import com.example.movieapp.ui_components.theme.underlinedDialogButton

@Composable
fun UnderlinedTextButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    onClick : () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorSchema.primary,
            contentColor = MaterialTheme.colorSchema.onPrimary,
            disabledContentColor = MaterialTheme.colorSchema.background,
            disabledContainerColor = MaterialTheme.colorSchema.disabledSecondary
        ),
        elevation = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(Paddings.small),
                text = id?.let { stringResource(id) } ?: text,
                style = MaterialTheme.typography.underlinedDialogButton,
            )
        }
    }
}