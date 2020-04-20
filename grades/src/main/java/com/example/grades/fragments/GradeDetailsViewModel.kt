package com.example.grades.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.entity.IndexDetails
import com.example.core.repository.IndexRepository
import kotlinx.coroutines.launch

class GradeDetailsViewModel(private val index: Int, private val repository: IndexRepository) : ViewModel() {
    private val _data = MediatorLiveData<IndexDetails>()
    val data: LiveData<IndexDetails>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repository.getIndexDetails(index))
    }
    init {
        getData()
    }
}
