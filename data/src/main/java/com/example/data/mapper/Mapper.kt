package com.example.data.mapper

import com.example.data.network.dto.CourseDto
import com.example.domain.model.Course

fun CourseDto.toDomain(): Course =
    Course (
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate
    )