package com.example.courseapp.presentation.vm

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseapp.presentation.vm.uistate.AuthUIState
import com.example.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(private val authUseCase: AuthUseCase): ViewModel() {

    private val _uiState = MutableStateFlow(AuthUIState())
    val uiState = _uiState.asStateFlow()

    fun onLoginChanged(value: String) {
        _uiState.update {
            it.copy(login = value)
        }
        validateFields()
    }

    fun onPasswordChanged(value: String) {
        _uiState.update {
            it.copy(password = value)
        }
        validateFields()
    }

    private fun validateFields() {
        val state = _uiState.value
        val isValid = Patterns.EMAIL_ADDRESS
            .matcher(state.login)
            .matches() && !state.password.isBlank()
        _uiState.update {
            it.copy(isButtonEnabled = isValid)
        }
    }

    private val _result = MutableSharedFlow<Result<String>>()
    val result = _result.asSharedFlow()

    fun signIn(login: String, password: String) {
        viewModelScope.launch {
            val result = authUseCase.execute(login, password)
            _result.emit(result)
        }
    }

}