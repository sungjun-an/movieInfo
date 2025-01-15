package com.example.movieapp.features.detail.domain.usecase

import com.example.movieapp.core.entity.MovieDetailEntity

interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}