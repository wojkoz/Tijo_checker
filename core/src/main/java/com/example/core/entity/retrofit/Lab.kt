package com.example.core.entity.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Lab(
    @Json(name = "dateOfLab")
    val dateOfLab: String,
    @Json(name = "points")
    val points: Int,
    @Json(name = "presence")
    val presence: Boolean
)