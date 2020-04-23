package com.example.core.repository

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.IndexDto
import com.example.core.resource.Resource

interface IndexRepository {
    suspend fun getAllIndexes(): Resource<List<IndexDto>>
    suspend fun getDetails(index: Int): Resource<IndexDetailsDto>
    suspend fun getIndexBynumber(number: Int): Resource<List<IndexDto>>
}