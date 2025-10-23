package com.example.domain.repository

import com.example.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {

    fun get(): Flow<Result<List<Course>>>

}