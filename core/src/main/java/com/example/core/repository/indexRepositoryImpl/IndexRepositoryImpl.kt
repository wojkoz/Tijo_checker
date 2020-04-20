package com.example.core.repository.indexRepositoryImpl

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.IndexDto
import com.example.core.entity.Index
import com.example.core.entity.IndexDetails
import com.example.core.mapper.Converter
import com.example.core.network.NetworkRepository
import com.example.core.repository.IndexRepository

class IndexRepositoryImpl(private val networkRepository: NetworkRepository,
                          private val itemMapper: Converter<IndexDetailsDto, IndexDetails>,
                          private val listMapper: Converter<List<IndexDto>, List<Index>>) : IndexRepository {



    override suspend fun getAllIndexes() = listMapper.convert(networkRepository.getAllIndexes())
    override suspend fun  getIndexDetails(index: Int) = itemMapper.convert(networkRepository.getIndexDetails(index))
}