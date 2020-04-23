package com.example.core.dao

import androidx.room.*
import com.example.core.entity.room.LabEntity

@Dao
interface LabDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<LabEntity>)

    @Delete
    suspend fun delete(item: LabEntity)

    @Update
    suspend fun update(list: List<LabEntity>)

    @Query("SELECT * FROM lab_table WHERE student_index = :index_number ORDER BY date_of_lab DESC")
    suspend fun getAll(index_number: Int): List<LabEntity>
}