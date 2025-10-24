package com.example.courseapp.presentation.mapper

import com.example.courseapp.R
import com.example.courseapp.presentation.model.CourseUI
import com.example.domain.model.Course

private val imageById = mapOf(
    100 to R.drawable.java_course,
    101 to R.drawable.three_d,
    102 to R.drawable.python
)

private val DEFAULT_IMG = R.drawable.java_course

fun Course.toUi(): CourseUI = CourseUI(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate,
    imageRes = imageById[id] ?: DEFAULT_IMG
)

fun CourseUI.toDomain(): Course = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate,
)