package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.network.ApiService
import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class CourseRepositoryImpl(private val apiService: ApiService): CourseRepository {

    override fun get(): Flow<Result<List<Course>>> = flow {
        try {
            val data = apiService.getCourses()
            emit(Result.success(data.courses.map { it.toDomain() }))
        } catch(ex: IOException) {
            emit(Result.failure(ex))
        } catch(ex: retrofit2.HttpException) {
            emit(Result.failure(ex))
        } catch(ex: Exception) {
            emit(Result.failure(ex))
        }
    }

}