package com.example.core.mapper

import com.example.core.dto.IndexDto
import com.example.core.entity.Index

class MapListToDto : Converter<List<IndexDto>, List<Index>> {
    override fun convert(item: List<Index>): List<IndexDto> {
        return item.map {
            IndexDto(
                absenceCounter = it.absenceCounter,
                allPoints = it.allPoints,
                group = it.group,
                homeworkPoints = it.homeworkPoints,
                index = it.index,
                lecturePoints = it.lecturePoints,
                mark = it.mark,
                presenceCounter = it.presenceCounter
            )
        }
    }

}