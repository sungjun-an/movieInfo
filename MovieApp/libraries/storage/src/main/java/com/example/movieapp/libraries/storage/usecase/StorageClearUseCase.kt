package com.example.movieapp.libraries.storage.usecase

import com.example.movieapp.libraries.storage_contract.IStorage
import javax.inject.Inject

class StorageClearUseCase @Inject constructor(
    private val storage: IStorage
) : IStorageClearUseCase {
    override fun invoke() {
        storage.clear()
    }
}
