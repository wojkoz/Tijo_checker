package com.example.grades.koin

import com.example.grades.fragments.IndexInfoListViewModel
import com.example.grades.fragments.details.IndexInfoDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { IndexInfoListViewModel(get()) }
    viewModel { (index: Int) ->
        IndexInfoDetailsViewModel(
            index,
            get()
        )
    }
}