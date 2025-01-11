package com.example.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.movieapp.ui.models.buttons.dialog.DialogButton
import com.example.movieapp.ui.models.buttons.dialog.DialogContent
import com.example.movieapp.ui.models.buttons.dialog.DialogText
import com.example.movieapp.ui.models.buttons.dialog.DialogTitle

@Composable
fun DialogPopup.Alert(
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