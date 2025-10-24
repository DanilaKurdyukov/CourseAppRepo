package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.CourseDAO
import com.example.data.local.entity.CourseEntity

@Database(
    entities = [
        CourseEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class DatabaseService: RoomDatabase() {
    abstract fun courseDao(): CourseDAO
}