package com.example.cleanexamplemvvm.domain.usecase.task

import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class GetUnclosedTasks(private val taskRepository: TaskRepository) {
    operator fun invoke(): List<Task> {
        return taskRepository.getUnclosedTasks()
    }
}
