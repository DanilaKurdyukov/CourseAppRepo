package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

class CourseResponseDto {
    data class CoursesResponse(
        @SerializedName("courses")
        val courses: List<CourseDto>
    )
}