package com.example.grades.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dto.IndexDto
import com.example.core.repository.IndexRepository
import com.example.core.resource.Resource
import com.example.core.resource.Status
import kotlinx.coroutines.launch

class IndexInfoListViewModel(private val repository: IndexRepository) : ViewModel() {

    private val _data = MutableLiveData<Resource<List<IndexDto>>>()
    val data: LiveData<Resource<List<IndexDto>>>
        get() = _data


    private fun getData() = viewModelScope.launch {
        _data.postValue(repository.getAllIndexes())
    }

    fun onSearch(number: Int){
        viewModelScope.launch {
            _data.postValue(repository.getIndexBynumber(number))
        }
    }

    fun onResetData(){
        getData()
    }

    init {
        _data.postValue(Resource(Status.LOADING, null, "Loading"))
        getData()
    }

}
