package com.example.core.entity.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lab_table")
class LabEntity(
    @ColumnInfo(name = "student_index") val studentIndex: Int,

    @ColumnInfo(name = "date_of_lab") val dateOfLab: String,

    @ColumnInfo(name = "points") val points: Int,

    @ColumnInfo(name = "presence") val presence: Boolean,

    @ColumnInfo(name = "lab_name") val labName: String
){
    @PrimaryKey(autoGenerate = true) var  id: Int? = null
}