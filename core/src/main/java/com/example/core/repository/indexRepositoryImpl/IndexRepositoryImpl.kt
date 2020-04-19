package com.example.core.repository.indexRepositoryImpl

import com.example.core.network.NetworkRepository
import com.example.core.repository.IndexRepository

class IndexRepositoryImpl(private val networkRepository: NetworkRepository) : IndexRepository {
    override suspend fun getAllIndexes() = networkRepository.getAllIndexes()
    override suspend fun  getIndexDetails(index: Int) = networkRepository.getIndexDetails(index)
}