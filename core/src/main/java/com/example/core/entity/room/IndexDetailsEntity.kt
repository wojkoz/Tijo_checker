package com.example.core.entity.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "index_details_table")
class IndexDetailsEntity(
    @PrimaryKey val index: String,

    @ColumnInfo(name = "group") val group: String

   // @Relation(parentColumn = "index", entityColumn = "studentIndex")
   // val labs: List<LabEntity>
)