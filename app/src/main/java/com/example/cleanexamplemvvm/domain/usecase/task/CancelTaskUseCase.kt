package com.example.cleanexamplemvvm.domain.usecase.task

import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class CancelTaskUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(task: Task): Task {
        if (!taskRepository.delete(task)) {
            //throw new NoSuchTaskException();
        }
        return task
    }
}
