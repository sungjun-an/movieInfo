package com.example.movieapp.features.feed.domain.usecase

import com.example.movieapp.core.entity.CategoryEntity
import com.example.movieapp.core.entity.EntityWrapper
import com.example.movieapp.core.data.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: com.example.movieapp.core.data.enum.SortOrder? = null): EntityWrapper<List<CategoryEntity>>
}