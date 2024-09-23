package com.example.spiderapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spiderapp.data.Spider
import com.example.spiderapp.data.SpiderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SpiderViewModel(private val repository: SpiderRepository) : ViewModel() {

    val spiderList: Flow<List<Spider>> = repository.getAllSpiders()

    fun getSpiderById(id: Int): Flow<Spider> = repository.getSpiderById(id)

    fun addOrUpdateSpider(id: Int? = null, nome: String, universo: String, afiliacao: String, poderes: String, edicao: Int) {
        val spider = Spider(id = id ?: 0, nome = nome, universo = universo, afiliacao = afiliacao, poderes = poderes, edicao = edicao)
        viewModelScope.launch {
            repository.insertSpider(spider)
        }
    }

    fun deleteSpider(spider: Spider) {
        viewModelScope.launch {
            repository.deleteSpider(spider)
        }
    }
}
