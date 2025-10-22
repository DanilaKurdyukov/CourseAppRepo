package com.example.domain.repository

interface AuthRepository {
    fun signIn(login: String, password: String): Result<String>
}