package com.example.movieapp.core.network.api

import com.example.movieapp.core.network.model.MovieResponse
import com.example.movieapp.libraries.network_contract.model.ApiResult
import com.example.movieapp.libraries.network_contract.api.NetworkRequestFactory
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MovieAppNetworkApi @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
): IMovieAppNetworkApi {
    override suspend fun getMovies(): ApiResult<List<MovieResponse>> {
        return networkRequestFactory.create(
            url = "top250.json",
            type = object : TypeToken<List<MovieResponse>>(){}.type
        )
    }
}