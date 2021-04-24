package com.osovan.serendipityapp.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nook(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val cover: String,
    val description: String,
    val location: String,
    val rating: Float
)