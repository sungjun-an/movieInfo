package com.example.movieapp.core.mapper

import com.example.movieapp.core.entity.CategoryEntity
import com.example.movieapp.core.entity.EntityWrapper
import com.example.movieapp.core.entity.MovieDetailEntity
import com.example.movieapp.core.network.model.MovieResponse
import com.example.movieapp.core.data.enum.SortOrder
import com.example.movieapp.libraries.storage_contract.IStorage
import com.example.movieapp.libraries.storage_contract.constants.StorageKeys
import javax.inject.Inject

class CategoryMapper @Inject constructor(
    private val storage: IStorage
): BaseMapper<List<MovieResponse>, List<CategoryEntity>>() {
    override fun getSuccess(
        model: List<MovieResponse>?,
        extra: Any?
    ): EntityWrapper.Success<List<CategoryEntity>> {
        return model?.let {
            EntityWrapper.Success(
                entity = mutableListOf<MovieDetailEntity>()
                    .apply { addAll(model.map { it.toMovieDetailEntity() }) }
                    .also { storage.save(StorageKeys.MOVIE_LIST_KEY, it) }
                    .map { it.toMovieThumbnailEntity() }
                    .toCategoryList(if (extra is SortOrder) extra else SortOrder.RATING)
            )
        } ?: EntityWrapper.Success(entity = listOf())
    }

    override fun getFailure(error: Throwable): EntityWrapper.Fail<List<CategoryEntity>> {
        return EntityWrapper.Fail(error)
    }
}