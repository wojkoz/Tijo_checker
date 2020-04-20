package com.example.grades.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dto.IndexDto
import com.example.core.repository.IndexRepository
import kotlinx.coroutines.launch

class IndexInfoListViewModel(private val repository: IndexRepository) : ViewModel() {

    private val _data = MediatorLiveData<List<IndexDto>>()
    val data: LiveData<List<IndexDto>>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repository.getAllIndexes())
    }
    init {
        getData()
    }

}
