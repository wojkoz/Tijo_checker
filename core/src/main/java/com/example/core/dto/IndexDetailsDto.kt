package com.example.core.dto

data class IndexDetailsDto(
    val group: String,
    val index: String,
    val labs: List<LabDto>
)