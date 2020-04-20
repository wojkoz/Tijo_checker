package com.example.grades.koin

import com.example.grades.fragments.GradeDetailsViewModel
import com.example.grades.fragments.GradesListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { GradesListViewModel(get()) }
    viewModel { (index: Int) ->
        GradeDetailsViewModel(
            index,
            get()
        )
    }
}