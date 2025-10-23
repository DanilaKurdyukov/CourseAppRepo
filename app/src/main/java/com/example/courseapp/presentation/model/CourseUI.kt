package com.example.courseapp.presentation.model

import androidx.annotation.DrawableRes

data class CourseUI(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: Double,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String,
    @DrawableRes
    val imageRes: Int
)
