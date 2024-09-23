package com.example.spiderapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spiderapp.data.SpiderRepository
import com.example.spiderapp.ui.SpiderViewModel

class SpiderViewModelFactory(private val repository: SpiderRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SpiderViewModel::class.java)) {
            return SpiderViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
