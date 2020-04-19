package com.example.core.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Index(
    @Json(name = "absenceCounter")
    val absenceCounter: Int,
    @Json(name = "allPoints")
    val allPoints: Int,
    @Json(name = "group")
    val group: String,
    @Json(name = "homeworkPoints")
    val homeworkPoints: Int,
    @Json(name = "index")
    val index: String,
    @Json(name = "lecturePoints")
    val lecturePoints: Int,
    @Json(name = "mark")
    val mark: Double,
    @Json(name = "presenceCounter")
    val presenceCounter: Int
)