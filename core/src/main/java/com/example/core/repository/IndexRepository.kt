package com.example.core.repository

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.IndexDto

interface IndexRepository {
    suspend fun getAllIndexes() : List<IndexDto>
    suspend fun getIndexDetails(index: Int): IndexDetailsDto
}