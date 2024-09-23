package com.example.spiderapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Spider::class], version = 1, exportSchema = false)
abstract class SpiderDatabase : RoomDatabase() {
    abstract fun spiderDao(): SpiderDao
}
