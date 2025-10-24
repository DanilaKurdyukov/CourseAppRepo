package com.example.domain.repository

import com.example.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {

    fun getRemote(): Flow<Result<List<Course>>>

    fun getLocal(): Flow<Result<List<Course>>>

    suspend fun insertCourse(course: Course): Result<Boolean>
}