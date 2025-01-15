package com.example.movieapp.core.repository

import com.example.movieapp.core.data.enum.SortOrder
import com.example.movieapp.core.entity.CategoryEntity
import com.example.movieapp.core.entity.EntityWrapper
import com.example.movieapp.core.entity.MovieDetailEntity

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}