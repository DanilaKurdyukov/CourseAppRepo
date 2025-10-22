package com.example.data.repository

import com.example.domain.model.AuthResult
import com.example.domain.repository.AuthRepository

class AuthRepositoryImpl: AuthRepository {

    override fun signIn(
        login: String,
        password: String
    ): AuthResult {
        return AuthResult.Success
    }
}