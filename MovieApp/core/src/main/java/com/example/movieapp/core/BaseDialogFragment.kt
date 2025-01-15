package com.example.movieapp.core

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.movieapp.core.viemodel.ThemeViewModel

open class BaseDialogFragment : DialogFragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}