package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CourseDto(
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "text")
    val text: String,
    @SerializedName(value = "price")
    val price: String,
    @SerializedName(value = "rate")
    val rate: Double,
    @SerializedName(value = "startDate")
    val startDate: String,
    @SerializedName(value = "hasLike")
    val hasLike: Boolean,
    @SerializedName(value = "publishDate")
    val publishDate: String
)