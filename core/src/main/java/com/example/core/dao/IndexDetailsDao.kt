package com.example.core.dao

import androidx.room.*
import com.example.core.entity.room.IndexDetailsEntity

@Dao
interface IndexDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: IndexDetailsEntity)

    @Delete
    suspend fun delete(item: IndexDetailsEntity)

    @Update
    suspend fun update(item: IndexDetailsEntity)

    @Query("SELECT * FROM index_details_table WHERE `index` = :index_number")
    suspend fun getOne(index_number: Int): IndexDetailsEntity
}