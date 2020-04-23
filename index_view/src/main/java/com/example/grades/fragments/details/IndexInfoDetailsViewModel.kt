package com.example.grades.fragments.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dto.IndexDetailsDto
import com.example.core.repository.IndexRepository
import com.example.core.resource.Resource
import com.example.core.resource.Status
import kotlinx.coroutines.launch

class IndexInfoDetailsViewModel(private val index: Int, private val repository: IndexRepository) : ViewModel() {
    private val _data = MutableLiveData<Resource<IndexDetailsDto>>()
    val data: LiveData<Resource<IndexDetailsDto>>
        get() = _data


    private fun getData() = viewModelScope.launch {
        _data.postValue(repository.getDetails(index))
    }

    init {
        _data.postValue(Resource(Status.LOADING, null, "Loading"))
        getData()
    }
}
