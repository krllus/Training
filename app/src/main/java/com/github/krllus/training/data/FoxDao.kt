package com.github.krllus.training.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface FoxDao {
    @Insert(onConflict = REPLACE)
    fun save(fox: Fox)

    @Query("SELECT * FROM fox WHERE id = :foxId")
    fun load(foxId: String): LiveData<Fox>


    fun hasFox(foxId: String): Boolean {
        val fox = load(foxId)
        return fox.value != null
    }
}