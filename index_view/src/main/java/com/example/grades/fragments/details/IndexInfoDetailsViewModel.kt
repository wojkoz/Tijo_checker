package com.example.grades.fragments.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dto.IndexDetailsDto
import com.example.core.repository.IndexRepository
import kotlinx.coroutines.launch

class IndexInfoDetailsViewModel(private val index: Int, private val repository: IndexRepository) : ViewModel() {
    private val _data = MediatorLiveData<IndexDetailsDto>()
    val data: LiveData<IndexDetailsDto>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repository.getIndexDetails(index))
    }
    init {
        getData()
    }
}
