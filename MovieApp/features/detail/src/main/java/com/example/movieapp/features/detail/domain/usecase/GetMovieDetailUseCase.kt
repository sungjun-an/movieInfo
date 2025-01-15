package com.example.movieapp.features.detail.domain.usecase

import com.example.movieapp.core.entity.MovieDetailEntity
import com.example.movieapp.core.repository.IMovieDataSource
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetMovieDetailUseCase {
    override suspend fun invoke(name: String): MovieDetailEntity {
        return dataSource.getMovieDetail(name)
    }
}