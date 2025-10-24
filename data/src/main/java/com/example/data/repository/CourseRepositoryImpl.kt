package com.example.data.repository

import com.example.data.local.dao.CourseDAO
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.data.remote.ApiService
import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okio.IOException

class CourseRepositoryImpl(
    private val apiService: ApiService,
    private val courseDAO: CourseDAO): CourseRepository {

    override fun getRemote(): Flow<Result<List<Course>>> = flow {
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

    override fun getLocal(): Flow<Result<List<Course>>> =
        courseDAO.getCourses()
            .map { data ->
                Result.success(data.map { it.toDomain() })
            }.catch { ex -> emit(Result.failure(ex)) }

    override suspend fun insertCourse(course: Course): Result<Boolean> {
        try{
            courseDAO.insert(course.toEntity())
            return Result.success(true)
        } catch(ex: Exception) {
            return Result.failure(ex)
        }

    }

}