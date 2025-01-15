package com.example.movieapp.core.mapper

import com.example.movieapp.core.entity.EntityWrapper
import com.example.movieapp.libraries.network_contract.model.ApiResponse
import com.example.movieapp.libraries.network_contract.model.ApiResult

abstract class BaseMapper<M, E> {

    fun mapFromResult(result: ApiResult<M>, extra: Any? = null): EntityWrapper<E> =
        when (result.response) {
            is ApiResponse.Success -> getSuccess(model = (result.response as ApiResponse.Success<M>).data, extra = extra)
            is ApiResponse.Fail -> getFailure(error = (result.response as ApiResponse.Fail).error)
        }

    abstract fun getSuccess(model: M?, extra: Any?): EntityWrapper.Success<E>

    abstract fun getFailure(error: Throwable): EntityWrapper.Fail<E>
}