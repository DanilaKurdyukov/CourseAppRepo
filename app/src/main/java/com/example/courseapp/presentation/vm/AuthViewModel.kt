package com.example.courseapp.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.AuthResult
import com.example.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authUseCase: AuthUseCase): ViewModel() {

    private val _result = MutableStateFlow<AuthResult>(value = AuthResult.Error(""))
    val result = _result.asStateFlow()

    fun getResult(login: String, password: String) {
        viewModelScope.launch {
            _result.value = authUseCase.execute(login, password)
        }
    }

}