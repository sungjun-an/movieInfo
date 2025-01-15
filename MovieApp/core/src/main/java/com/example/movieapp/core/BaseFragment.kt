package com.example.movieapp.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.movieapp.core.viemodel.ThemeViewModel

open class BaseFragment : Fragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}