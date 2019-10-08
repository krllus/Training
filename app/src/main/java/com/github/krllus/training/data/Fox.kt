package com.github.krllus.training.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fox(
    @PrimaryKey val id: String,
    val image: String,
    val link: String
)