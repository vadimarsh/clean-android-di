package com.example.cleanexamplemvvm.di

import com.example.cleanexamplemvvm.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentation = module {
    viewModel<MainViewModel> {
        MainViewModel(
            createTaskUseCase = get(),
            getAllTasksUseCase = get()
        )
    }
}
