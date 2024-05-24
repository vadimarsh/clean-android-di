package com.example.cleanexamplemvvm.domain.usecase.task

import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class SetDeadLineUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(task: Task, deadline: Long): Task {
        task.deadline = deadline
        return taskRepository.update(task)
    }
}
