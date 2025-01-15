package com.example.movieapp.di

import com.example.movieapp.libraries.storage_contract.IStorage
import com.example.movieapp.libraries.storage.StorageManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.movieapp.libraries.storage.helpers.DataConverter
import com.example.movieapp.libraries.storage.helpers.DataEncoding
import com.example.movieapp.libraries.storage.prefs.SharedPrefsStorageProvider
import com.example.movieapp.libraries.storage.prefs.StorageProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Provides
    fun bindOnDiscStorage(
        storage: StorageProvider,
        converter: DataConverter,
        encoding: DataEncoding
    ): IStorage = StorageManager(storage, converter, encoding)

    @Provides
    fun provideSharePrefStorageProvider(provider: SharedPrefsStorageProvider): StorageProvider =
        provider

}
