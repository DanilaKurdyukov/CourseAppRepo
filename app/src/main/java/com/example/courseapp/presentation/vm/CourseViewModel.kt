package com.example.courseapp.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseapp.presentation.mapper.toUi
import com.example.courseapp.presentation.model.CourseUI
import com.example.domain.model.Course
import com.example.domain.usecase.GetCourseUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CourseViewModel(private val courseUseCase: GetCourseUseCase): ViewModel() {

    private val _courses = MutableStateFlow(emptyList<CourseUI>())
    val courses = _courses.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    fun getCourses() {
        viewModelScope.launch {
            courseUseCase.execute().collectLatest { result ->
                result.onSuccess { data ->
                    _courses.value = data.map { it.toUi() }
                }.onFailure { error ->
                    _error.emit(error.message ?: "Unknown error")
                }
            }
        }
    }

}