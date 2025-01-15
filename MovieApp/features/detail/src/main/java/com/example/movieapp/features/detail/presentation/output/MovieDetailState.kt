package com.example.movieapp.features.detail.presentation.output

import com.example.movieapp.core.entity.MovieDetailEntity

sealed class MovieDetailState {
    object Initial: MovieDetailState()
    class Main(val movieDetailEntity: MovieDetailEntity): MovieDetailState()
    class Failed(val reason: String): MovieDetailState()
}