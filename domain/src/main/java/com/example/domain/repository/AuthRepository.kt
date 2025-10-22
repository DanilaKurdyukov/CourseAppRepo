package com.example.domain.repository

import com.example.domain.model.AuthResult

interface AuthRepository {
    fun signIn(login: String, password: String): AuthResult
}