package com.example.movieapp.features.feed.domain.usecase

import com.example.movieapp.core.entity.CategoryEntity
import com.example.movieapp.core.entity.EntityWrapper
import com.example.movieapp.core.repository.IMovieDataSource
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
): IGetFeedCategoryUseCase {
    override suspend fun invoke(sortOrder: com.example.movieapp.core.data.enum.SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories(sortOrder)
    }
}