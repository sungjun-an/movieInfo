package com.example.movieapp.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.movieapp.ui.components.dialog.components.button.DialogButtonsColumn
import com.example.movieapp.ui.components.dialog.components.content.DialogContentWrapper
import com.example.movieapp.ui.components.dialog.components.title.DialogTitleWrapper
import com.example.movieapp.ui.models.buttons.dialog.DialogButton
import com.example.movieapp.ui.models.buttons.dialog.DialogContent
import com.example.movieapp.ui.models.buttons.dialog.DialogTitle
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.theme.colorSchema

@Composable
fun BaseDialogPopup(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Paddings.none
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorSchema.background
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let {
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Paddings.xlarge,
                        end = Paddings.xlarge,
                        bottom = Paddings.xlarge
                    )
            ) {
                dialogContent?.let { DialogContentWrapper(it) }
                buttons?.let { DialogButtonsColumn(it) }
            }
        }
    }
}