package com.example.movieapp.ui_components.components.dialog.components.content

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.em
import com.example.movieapp.ui_components.models.buttons.dialog.DialogContent
import com.example.movieapp.ui_components.models.buttons.dialog.DialogText
import com.example.movieapp.ui_components.theme.Paddings

data class DialogContentStyle (
    val textStyle: @Composable () -> TextStyle = { MaterialTheme.typography.bodyLarge },
    val contentTopPadding: Dp = Paddings.xlarge,
    val contentBottomPadding: Dp = Paddings.extra
)

val LocalDialogContentStyle = compositionLocalOf { DialogContentStyle() }

@Composable
fun ColumnScope.DialogContentWrapper(
    content: DialogContent
) {
    when(content) {
        is DialogContent.Default -> {
            CompositionLocalProvider(
                LocalDialogContentStyle provides DialogContentStyle(
                    textStyle = { MaterialTheme.typography.bodyMedium.copy(lineHeight = 1.6.em) },
                    contentTopPadding = Paddings.small,
                    contentBottomPadding = Paddings.extra
                )
            ) { NormalTextContent(content.dialogText) }
        }
        is DialogContent.Large -> {
            CompositionLocalProvider(
                LocalDialogContentStyle provides DialogContentStyle(
                    textStyle = { MaterialTheme.typography.titleLarge.copy(lineHeight = 1.6.em) },
                    contentTopPadding = Paddings.extra,
                    contentBottomPadding = Paddings.extra
                )
            ) { NormalTextContent(content.dialogText) }
        }
        is DialogContent.Rating -> {
            RatingContent(content.dialogText)
        }
    }
}

@Composable
fun ColumnScope.NormalTextContent(
    text: DialogText.Default
) {
    Text(
        modifier = Modifier
            .padding(
                top = LocalDialogContentStyle.current.contentTopPadding,
                bottom = LocalDialogContentStyle.current.contentBottomPadding
            )
            .align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        style = LocalDialogContentStyle.current.textStyle.invoke(),
        text = getStringFromDialogText(text)
    )
}

@Composable
fun getStringFromDialogText(text: DialogText.Default):String {
    return text.id?.let { stringResource(id = it) } ?: text.text ?: ""
}