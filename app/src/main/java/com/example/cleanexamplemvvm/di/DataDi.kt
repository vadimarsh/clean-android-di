package com.example.cleanexamplemvvm.di

import com.example.cleanexamplemvvm.data.repository.inmemory.InMemoryDiscipRepository
import com.example.cleanexamplemvvm.data.repository.inmemory.InMemoryTaskRepository
import com.example.cleanexamplemvvm.domain.port.DisciplineRepository
import com.example.cleanexamplemvvm.domain.port.TaskRepository
import org.koin.dsl.module

val data = module {
    single<DisciplineRepository> { InMemoryDiscipRepository() }
    single<TaskRepository> { InMemoryTaskRepository() }
}