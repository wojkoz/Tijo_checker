package com.example.core.entity.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "index_table")
class IndexEntity(@PrimaryKey val index: String,

                  @ColumnInfo(name = "absence_counter") val absenceCounter: Int,

                  @ColumnInfo(name = "all_points") val allPoints: Int,

                  @ColumnInfo(name = "group") val group: String,

                  @ColumnInfo(name = "homework_points") val homeworkPoints: Int,

                  @ColumnInfo(name = "lecture_points") val lecturePoints: Int,

                  @ColumnInfo(name = "mark") val mark: Double,

                  @ColumnInfo(name = "presence_counter") val presenceCounter: Int)