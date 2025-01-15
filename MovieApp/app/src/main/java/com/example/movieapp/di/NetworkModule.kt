package com.example.movieapp.di

import com.example.movieapp.libraries.network.retrofit.NetworkRequestFactoryImpl
import com.example.movieapp.libraries.network_contract.api.NetworkRequestFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun bindNetworkRequestFactory(networkRequestFactory: NetworkRequestFactoryImpl): NetworkRequestFactory =
        networkRequestFactory
}