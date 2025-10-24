package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow

class InsertCourseUseCase(private val courseRepository: CourseRepository) {

    suspend fun execute(course: Course): Result<Boolean> = courseRepository.insertCourse(course)

}