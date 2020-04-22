package com.example.core.repository.indexRepositoryImpl

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.IndexDto
import com.example.core.entity.Index
import com.example.core.entity.IndexDetails
import com.example.core.mapper.Converter
import com.example.core.network.NetworkRepository
import com.example.core.repository.IndexRepository
import com.example.core.resource.Resource
import com.example.core.responseHandler.ResponseHandler

class IndexRepositoryImpl(private val networkRepository: NetworkRepository,
                          private val itemMapper: Converter<IndexDetailsDto, IndexDetails>,
                          private val listMapper: Converter<List<IndexDto>, List<Index>>,
                          private val responseHandler: ResponseHandler) : IndexRepository {



    override suspend fun getAllIndexes(): Resource<List<IndexDto>> {
        return try {
            val indexList = listMapper.convert(networkRepository.getAllIndexes())
            responseHandler.handleSuccess(indexList)
        }catch (e: Exception){
            return responseHandler.handleException(e)
        }
    }
    override suspend fun  getIndexDetails(index: Int): Resource<IndexDetailsDto>{
        return try {
            val item =itemMapper.convert(networkRepository.getIndexDetails(index))
            responseHandler.handleSuccess(item)
        }catch (e: Exception){
            return responseHandler.handleException(e)
        }
    }
}