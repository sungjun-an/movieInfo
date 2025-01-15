package com.example.movieapp.core.repository

import com.example.movieapp.core.data.enum.SortOrder
import com.example.movieapp.core.mapper.CategoryMapper
import com.example.movieapp.core.entity.CategoryEntity
import com.example.movieapp.core.entity.EntityWrapper
import com.example.movieapp.core.entity.MovieDetailEntity
import com.example.movieapp.core.network.api.IMovieAppNetworkApi
import com.example.movieapp.libraries.storage_contract.IStorage
import com.example.movieapp.libraries.storage_contract.constants.StorageKeys
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi,
    private val storage: IStorage,
    private val categoryMapper: CategoryMapper
) : IMovieDataSource {

    override suspend fun getCategories(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return categoryMapper.mapFromResult(
            result = movieNetworkApi.getMovies(),
            extra = sortOrder
        )
    }

    override suspend fun getMovieDetail(movieName: String): MovieDetailEntity {
        return storage
            .get<List<MovieDetailEntity>>(StorageKeys.MOVIE_LIST_KEY)
            ?.single { it.title == movieName }
            ?: MovieDetailEntity()
    }
}