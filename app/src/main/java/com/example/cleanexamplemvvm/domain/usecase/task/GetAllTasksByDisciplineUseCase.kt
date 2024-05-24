package com.example.cleanexamplemvvm.domain.usecase.task

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class GetAllTasksByDisciplineUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(discipline: Discipline): List<Task> {
        return taskRepository.findByDiscipline(discipline)
    }
}
