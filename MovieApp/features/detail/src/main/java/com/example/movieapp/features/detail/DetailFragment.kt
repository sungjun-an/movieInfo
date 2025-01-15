package com.example.movieapp.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.movieapp.core.BaseFragment
import com.example.movieapp.features.detail.presentation.MovieDetailScreen
import com.example.movieapp.features.detail.presentation.output.DetailUiEffect
import com.example.movieapp.features.detail.presentation.viewmodel.MovieDetailViewModel
import com.example.movieapp.ui_components.navigation.safeNavigate
import com.example.movieapp.ui_components.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment: BaseFragment() {

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        observeUiEffects()
        return ComposeView(requireContext()).apply {
            setContent {
                MovieAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    MovieDetailScreen(
                        movieDetailState = viewModel.outputs.detailState.collectAsState(),
                        input = viewModel.inputs
                    )
                }
            }
        }
    }

    private fun init() {
        val movieName = arguments?.getString("movieName") ?: ""
        lifecycleScope.launch {
            viewModel.initMovieName(movieName)
        }
    }

    private fun observeUiEffects() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.outputs.detailUiEffect.collectLatest {
                    when (it) {
                        is DetailUiEffect.Back -> {
                            findNavController().safeNavigate(
                                "App://Feed"
                            )
                        }

                        is DetailUiEffect.OpenUrl -> {
                            findNavController().safeNavigate(
                                "App://IMDB/${it.url}"
                            )
                        }

                        is DetailUiEffect.RateMovie -> {
                            findNavController().safeNavigate(
                                "App://Rating/${it.movieTitle}/${it.rating}"
                            )
                        }
                    }
                }
            }
        }
    }
}