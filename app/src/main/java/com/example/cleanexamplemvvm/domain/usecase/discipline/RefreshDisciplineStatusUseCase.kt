package com.example.cleanexamplemvvm.domain.usecase.discipline

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.port.DisciplineRepository
import com.example.cleanexamplemvvm.domain.port.TaskRepository

class RefreshDisciplineStatusUseCase(
    private val disciplineRepository: DisciplineRepository,
    private val taskRepository: TaskRepository
) {
    operator fun invoke(discipline: Discipline): Discipline {
        if (checkTasks(discipline)) {
            discipline.closed = true
            // disciplineRepository.update(discipline);
        } else {
            discipline.closed = false
        }
        disciplineRepository.update(discipline)
        return discipline
    }

    private fun checkTasks(discipline: Discipline): Boolean {
        var flag = true
        val tasksByDiscipline = taskRepository.findByDiscipline(discipline)
        for (i in tasksByDiscipline!!.indices) {
            if (!tasksByDiscipline[i].isClosed) {
                flag = false
                break
            }
        }
        return flag
    }
}
