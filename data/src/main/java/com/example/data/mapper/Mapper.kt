package com.example.data.mapper

import com.example.data.local.entity.CourseEntity
import com.example.data.remote.dto.CourseDto
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

fun CourseDto.toEntity(): CourseEntity =
    CourseEntity (
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate
    )

fun Course.toEntity(): CourseEntity  =
    CourseEntity (
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate
    )

fun CourseEntity.toDomain(): Course =
    Course(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate
    )