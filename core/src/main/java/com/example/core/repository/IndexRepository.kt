package com.example.core.repository

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.IndexDto
import com.example.core.resource.Resource

interface IndexRepository {
    suspend fun getAllIndexes() : Resource<List<IndexDto>>
    suspend fun getIndexDetails(index: Int): Resource<IndexDetailsDto>
}