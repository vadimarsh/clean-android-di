package com.example.cleanexamplemvvm.di

import com.example.cleanexamplemvvm.domain.usecase.task.CreateTaskUseCase
import com.example.cleanexamplemvvm.domain.usecase.task.GetAllTasksByDisciplineUseCase
import com.example.cleanexamplemvvm.domain.usecase.task.GetAllTasksUseCase
import org.koin.dsl.module

val domain = module {
    factory<CreateTaskUseCase> { CreateTaskUseCase(taskRepository = get()) }
    factory<GetAllTasksByDisciplineUseCase> { GetAllTasksByDisciplineUseCase(taskRepository = get()) }
    factory<GetAllTasksUseCase> { GetAllTasksUseCase(taskRepository = get()) }
}