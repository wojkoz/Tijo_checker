package com.example.core.mapper

import com.example.core.dto.IndexDto
import com.example.core.entity.retrofit.Index
import com.example.core.entity.room.IndexEntity

class IndexMapper {
    fun mapIndexEntityToDto(list: List<IndexEntity>): List<IndexDto> {
        return list.map {
            IndexDto(
                index = it.index,
                group = it.group,
                presenceCounter = it.presenceCounter,
                mark = it.mark,
                lecturePoints = it.lecturePoints,
                homeworkPoints = it.homeworkPoints,
                allPoints = it.allPoints,
                absenceCounter = it.absenceCounter
            )
        }
    }

    fun mapIndexToEntity(list: List<Index>): List<IndexEntity>{
        return list.map {
            IndexEntity(
                index = it.index,
                group = it.group,
                absenceCounter = it.absenceCounter,
                allPoints = it.allPoints,
                homeworkPoints = it.homeworkPoints,
                lecturePoints = it.lecturePoints,
                mark = it.mark,
                presenceCounter = it.presenceCounter
            )
        }
    }
}