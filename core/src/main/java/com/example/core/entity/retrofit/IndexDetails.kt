package com.example.core.entity.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IndexDetails(
    @Json(name = "group")
    val group: String,
    @Json(name = "index")
    val index: String,
    @Json(name = "labs")
    val labs: List<Lab>
)