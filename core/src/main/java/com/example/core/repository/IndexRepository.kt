package com.example.core.repository

import com.example.core.entity.Index
import com.example.core.entity.IndexDetails

interface IndexRepository {
    suspend fun getAllIndexes() : List<Index>
    suspend fun getIndexDetails(index: Int): IndexDetails
}