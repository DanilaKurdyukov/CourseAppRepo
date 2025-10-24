package com.example.domain.usecase

import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow

class GetLocalCourseUseCase(private val courseRepository: CourseRepository) {

    fun execute(): Flow<Result<List<Course>>> = courseRepository.getLocal()

}