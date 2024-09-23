package com.example.spiderapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SpiderDao {
    @Query("SELECT * FROM spider_verso")
    fun getAllSpiders(): Flow<List<Spider>>

    @Query("SELECT * FROM spider_verso WHERE id = :id")
    fun getSpiderById(id: Int): Flow<Spider>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpider(spider: Spider)

    @Delete
    suspend fun deleteSpider(spider: Spider)
}
