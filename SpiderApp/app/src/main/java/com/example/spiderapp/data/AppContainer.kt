package com.example.spiderapp.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: SpiderDatabase by lazy {
        Room.databaseBuilder(context, SpiderDatabase::class.java, "spider_db").build()
    }

    val spiderRepository: SpiderRepository by lazy {
        SpiderRepository(database.spiderDao())
    }
}