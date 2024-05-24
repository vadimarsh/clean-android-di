package com.example.cleanexamplemvvm.domain.usecase.discipline

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.port.DisciplineRepository

class CreateDisciplineUseCase(private val disciplineRepository: DisciplineRepository) {
    operator fun invoke(discipline: Discipline): Discipline {
        return disciplineRepository.create(discipline)
    }
}
