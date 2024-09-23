package com.example.spiderapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spider_verso")
data class Spider(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val universo: String,
    val afiliacao: String,
    val poderes: String,
    val edicao: Int
)
