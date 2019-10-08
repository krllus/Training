package com.github.krllus.training.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Fox::class], version = 1)
abstract class AppDatabase : RoomDatabase()