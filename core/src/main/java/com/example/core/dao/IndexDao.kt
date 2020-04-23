package com.example.core.dao

import androidx.room.*
import com.example.core.entity.room.IndexEntity


@Dao
interface IndexDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<IndexEntity>)

    @Delete
    suspend fun delete(item: IndexEntity)

    @Update
    suspend fun update(list: List<IndexEntity>)

    @Query("SELECT * FROM index_table WHERE `index` LIKE :number || '%'")
    suspend fun getBySomeNumbers(number: Int): List<IndexEntity>

    @Query("SELECT * FROM index_table")
    suspend fun getAll(): List<IndexEntity>

}