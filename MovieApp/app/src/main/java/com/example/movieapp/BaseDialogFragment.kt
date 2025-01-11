package com.example.movieapp

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.movieapp.features.common.viemodel.ThemeViewModel

open class BaseDialogFragment : DialogFragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}