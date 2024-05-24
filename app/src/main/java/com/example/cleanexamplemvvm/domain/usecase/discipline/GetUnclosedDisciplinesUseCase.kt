package com.example.cleanexamplemvvm.domain.usecase.discipline

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.port.DisciplineRepository

class GetUnclosedDisciplinesUseCase(private val disciplineRepository: DisciplineRepository) {
    operator fun invoke(): List<Discipline> {
        val disciplines: List<Discipline> = disciplineRepository.getAllDisciplines()
        val unClosedDisciplines: MutableList<Discipline> = ArrayList()
        for (i in disciplines.indices) {
            if (disciplines[i].closed) {
                unClosedDisciplines.add(disciplines[i])
            }
        }
        return unClosedDisciplines
    }
}
