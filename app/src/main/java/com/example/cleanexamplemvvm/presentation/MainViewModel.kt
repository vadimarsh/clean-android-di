package com.example.cleanexamplemvvm.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanexamplemvvm.data.repository.inmemory.InMemoryTaskRepository
import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository
import com.example.cleanexamplemvvm.domain.usecase.task.CreateTaskUseCase
import com.example.cleanexamplemvvm.domain.usecase.task.GetAllTasksUseCase

class MainViewModel(
    private val getAllTasksUseCase:GetAllTasksUseCase,
    private val createTaskUseCase:CreateTaskUseCase
    ):ViewModel(){
    val resultLive = MutableLiveData<List<Task>>()
    fun load() {
        resultLive.value = getAllTasksUseCase.invoke()
    }

    fun save(task:Task){
        createTaskUseCase.invoke(task)
        load()
    }
}