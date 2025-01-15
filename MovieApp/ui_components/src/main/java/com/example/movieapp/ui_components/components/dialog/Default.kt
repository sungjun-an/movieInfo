package com.example.movieapp.ui_components.components.dialog

import androidx.compose.runtime.Composable
import com.example.movieapp.ui_components.models.buttons.dialog.DialogButton
import com.example.movieapp.ui_components.models.buttons.dialog.DialogContent
import com.example.movieapp.ui_components.models.buttons.dialog.DialogText
import com.example.movieapp.ui_components.models.buttons.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header(title),
        dialogContent = DialogContent.Large(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}