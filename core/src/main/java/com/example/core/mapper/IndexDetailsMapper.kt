package com.example.core.mapper

import com.example.core.dto.IndexDetailsDto
import com.example.core.dto.LabDto
import com.example.core.entity.retrofit.IndexDetails
import com.example.core.entity.retrofit.Lab
import com.example.core.entity.room.IndexDetailsEntity
import com.example.core.entity.room.LabEntity

class IndexDetailsMapper {
    fun mapIndexDetailsToEntity(detail: IndexDetails): IndexDetailsEntity{
        return IndexDetailsEntity(
            group = detail.group,
            index = detail.index
        )
    }

    fun mapLabToEntity(labs: List<Lab>, index: Int): List<LabEntity>{
        var labSize = labs.size + 1
       return labs.map {
            labSize--
            LabEntity(
                dateOfLab = it.dateOfLab,
                points = it.points,
                presence = it.presence,
                labName = "Lab $labSize",
                studentIndex = index
            )
        }
    }

    fun mapIndexDetailsEntityToDto(detail: IndexDetailsEntity, labs: List<LabEntity>): IndexDetailsDto{
        val labsDto = labs.map {
            LabDto(
                dateOfLab = it.dateOfLab,
                points = it.points,
                presence = it.presence,
                labName = it.labName
            )
        }

        return IndexDetailsDto(
            group = detail.group,
            index = detail.index,
            labs = labsDto
        )
    }
}