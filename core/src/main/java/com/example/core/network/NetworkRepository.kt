package com.example.core.network

import com.example.core.entity.retrofit.Index
import com.example.core.entity.retrofit.IndexDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkRepository {
    @GET("students")
    suspend fun getAllIndexes(): List<Index>

    @GET("students/{index}")
    suspend fun getIndexDetails(@Path("index") index: Int): IndexDetails
}