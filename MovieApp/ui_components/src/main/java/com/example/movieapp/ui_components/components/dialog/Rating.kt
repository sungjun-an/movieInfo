package com.example.movieapp.ui_components.components.dialog

import androidx.compose.runtime.Composable
import com.example.movieapp.ui_components.models.buttons.dialog.DialogButton
import com.example.movieapp.ui_components.models.buttons.dialog.DialogContent
import com.example.movieapp.ui_components.models.buttons.dialog.DialogText
import com.example.movieapp.ui_components.models.buttons.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}