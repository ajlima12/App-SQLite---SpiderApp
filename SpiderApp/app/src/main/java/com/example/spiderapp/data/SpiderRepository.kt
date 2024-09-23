package com.example.spiderapp.data

import kotlinx.coroutines.flow.Flow

open class SpiderRepository(private val spiderDao: SpiderDao) {
    fun getAllSpiders(): Flow<List<Spider>> = spiderDao.getAllSpiders()

    fun getSpiderById(id: Int): Flow<Spider> = spiderDao.getSpiderById(id)

    suspend fun insertSpider(spider: Spider) = spiderDao.insertSpider(spider)

    suspend fun deleteSpider(spider: Spider) = spiderDao.deleteSpider(spider)
}
