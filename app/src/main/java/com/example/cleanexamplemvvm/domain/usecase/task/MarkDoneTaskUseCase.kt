package com.example.cleanexamplemvvm.domain.usecase.task

import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class MarkDoneTaskUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(task: Task): Task {
        task.changeState()
        return taskRepository.update(task)
    }
}
