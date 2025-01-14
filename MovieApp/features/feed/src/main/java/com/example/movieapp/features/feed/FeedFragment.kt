package com.example.movieapp.features.feed

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
import com.example.movieapp.features.feed.presentation.output.FeedUiEffect
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.example.movieapp.features.feed.presentation.screen.FeedScreen
import com.example.movieapp.features.feed.presentation.viewmodel.FeedViewModel
import com.example.movieapp.ui_components.navigation.safeNavigate
import com.example.movieapp.ui_components.theme.MovieAppTheme

@AndroidEntryPoint
class FeedFragment: BaseFragment() {

    private val viewModel : FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        observeUiEffects()
        return ComposeView(requireContext()).apply {
            setContent {
                MovieAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    FeedScreen(
                        feedStateHolder = viewModel.output.feedState.collectAsState(),
                        input = viewModel.input,
                        buttonColor = themeViewModel.nextColorState.collectAsState(),
                        changeAppColor = { themeViewModel.toggleColorSet() }
                    )
                }
            }
        }
    }

    private fun observeUiEffects() {
        val navController = findNavController()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.output.feedUiEffect.collectLatest {
                    when (it) {
                        is FeedUiEffect.OpenMovieDetail -> {
                            navController.safeNavigate(
                                "App://Detail/${it.movieName}"
                            )
                        }

                        is FeedUiEffect.OpenInfoDialog -> {
                            navController.safeNavigate(
                                "App://Info"
                            )
                        }
                    }
                }
            }
        }
    }
}