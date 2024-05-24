package com.example.cleanexamplemvvm.domain.usecase.discipline

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.port.DisciplineRepository

class GetAllDisciplinesUseCase(private val disciplineRepository: DisciplineRepository) {
    operator fun invoke(): List<Discipline> {
        return disciplineRepository.getAllDisciplines()
    }
}
