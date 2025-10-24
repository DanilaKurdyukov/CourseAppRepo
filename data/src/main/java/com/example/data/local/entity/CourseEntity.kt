package com.example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "rate") val rate: Double,
    @ColumnInfo(name = "startDate") val startDate: String,
    @ColumnInfo(name = "hasLike") val hasLike: Boolean,
    @ColumnInfo(name = "publishDate") val publishDate: String
)
