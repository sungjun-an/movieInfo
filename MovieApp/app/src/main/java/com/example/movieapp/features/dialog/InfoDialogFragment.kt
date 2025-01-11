package com.example.movieapp.features.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import com.example.movieapp.BaseDialogFragment
import com.example.movieapp.R
import com.example.movieapp.ui.components.dialog.Alert
import com.example.movieapp.ui.components.dialog.DialogPopup
import com.example.movieapp.ui.models.buttons.dialog.DialogButton
import com.example.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoDialogFragment : BaseDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.apply {
            isCancelable = true
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MovieAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    DialogPopup.Alert(
                        title = stringResource(R.string.app_name),
                        bodyText = stringResource(R.string.info_message),
                        buttons = listOf(
                            DialogButton.UnderlinedText(getString(R.string.close)) {
                                dismiss()
                            }
                        )
                    )
                }
            }
        }
    }
}