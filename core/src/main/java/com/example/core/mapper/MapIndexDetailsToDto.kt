package com.example.core.mapper

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.LabDto
import com.example.core.entity.IndexDetails

class MapIndexDetailsToDto : Converter<IndexDetailsDto, IndexDetails> {
    override fun convert(item: IndexDetails): IndexDetailsDto {

        val labsDto = item.labs.map {
            LabDto(
                dateOfLab = it.dateOfLab,
                points = it.points,
                presence = it.presence
            )
        }

        return IndexDetailsDto(
            group = item.group,
            index = item.index,
            labs = labsDto
        )
    }
}