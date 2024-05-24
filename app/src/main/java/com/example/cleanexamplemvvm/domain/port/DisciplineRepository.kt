package com.example.cleanexamplemvvm.domain.port

import com.example.cleanexamplemvvm.domain.entity.Discipline

interface DisciplineRepository {
    fun create(discipline: Discipline): Discipline
    fun getAllDisciplines(): List<Discipline>
    fun update(discipline: Discipline)
    fun getDisciplineByID(id: Int): Discipline
}
