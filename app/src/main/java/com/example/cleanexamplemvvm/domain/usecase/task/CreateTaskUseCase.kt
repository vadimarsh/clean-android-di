package com.example.cleanexamplemvvm.domain.usecase.task

import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class CreateTaskUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(task: Task): Task {
        return taskRepository.create(task)
    }
}
