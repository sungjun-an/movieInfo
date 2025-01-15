package com.example.movieapp.core.network.api

import com.example.movieapp.core.network.model.MovieResponse
import com.example.movieapp.libraries.network_contract.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}