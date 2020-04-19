package com.example.grades.koin

import com.example.grades.GradeDetailsViewModel
import com.example.grades.GradesListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { GradesListViewModel(get()) }
    viewModel { (index: Int) -> GradeDetailsViewModel(index, get()) }
}