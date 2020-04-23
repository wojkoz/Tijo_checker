package com.example.core.repository.indexRepositoryImpl

import com.example.core.database.IndexDatabase
import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.IndexDto
import com.example.core.entity.retrofit.Index
import com.example.core.entity.retrofit.IndexDetails
import com.example.core.mapper.IndexDetailsMapper
import com.example.core.mapper.IndexMapper
import com.example.core.network.NetworkRepository
import com.example.core.repository.IndexRepository
import com.example.core.resource.Resource
import com.example.core.resource.Status
import com.example.core.responseHandler.ResponseHandler

class IndexRepositoryImpl(private val networkRepository: NetworkRepository,
                          private val database: IndexDatabase,
                          private val responseHandler: ResponseHandler) : IndexRepository {

    private val indexMapper = IndexMapper()
    private val detailsMapper = IndexDetailsMapper()


    private suspend fun getIndexes(): Resource<List<Index>> {
        return try {
            val indexList = networkRepository.getAllIndexes()
            responseHandler.handleSuccess(indexList)
        }catch (e: Exception){
            return responseHandler.handleException(e)
        }
    }
    private suspend fun  getIndexDetails(index: Int): Resource<IndexDetails>{
        return try {
            val item = networkRepository.getIndexDetails(index)
            responseHandler.handleSuccess(item)
        }catch (e: Exception){
            return responseHandler.handleException(e)
        }
    }

    override suspend fun getAllIndexes(): Resource<List<IndexDto>> {
        val resource = getIndexes()

        return if(resource.status == Status.SUCCESS){
            val entityList = indexMapper.mapIndexToEntity(resource.data!!)
            database.indexDao().insertAll(entityList)
            val dtoList = indexMapper.mapIndexEntityToDto(entityList)
            Resource(status = resource.status, data = dtoList, message = null)
        } else{
            val dtoList = indexMapper.mapIndexEntityToDto(database.indexDao().getAll())
            Resource(status = resource.status, data = dtoList, message = resource.message)
        }

    }

    override suspend fun getDetails(index: Int): Resource<IndexDetailsDto> {
        val resource = getIndexDetails(index)

        return if(resource.status == Status.SUCCESS){
            val entity = detailsMapper.mapIndexDetailsToEntity(resource.data!!)
            val labEntityList = detailsMapper.mapLabToEntity(resource.data.labs, resource.data.index.toInt())
            database.indexDetailsDao().insert(entity)
            database.labDao().insertAll(labEntityList)

            val dto = detailsMapper.mapIndexDetailsEntityToDto(entity, labEntityList)

            Resource(status = resource.status, data = dto, message = resource.message)
        }else{
            val dto = detailsMapper.mapIndexDetailsEntityToDto(database.indexDetailsDao().getOne(index), database.labDao().getAll(index))
            Resource(status = resource.status, data = dto, message = resource.message)
        }

    }

    override suspend fun getIndexBynumber(number: Int): Resource<List<IndexDto>> {
        val bySomeNumbers = database.indexDao().getBySomeNumbers(number)
        val dtoList = indexMapper.mapIndexEntityToDto(bySomeNumbers)

        return Resource(status = Status.SUCCESS, data = dtoList, message = null)
    }
}