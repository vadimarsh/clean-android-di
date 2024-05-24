package com.example.cleanexamplemvvm.data.repository.inmemory

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.port.DisciplineRepository

class InMemoryDiscipRepository : DisciplineRepository {
    private val disciplines: MutableList<Discipline> = ArrayList()
    override fun create(discipline: Discipline): Discipline {
        disciplines.add(discipline)
        return discipline
    }

    override fun getAllDisciplines(): List<Discipline> {
        return disciplines
    }

    override fun update(discipline: Discipline) {
        disciplines[disciplines.indexOf(discipline)] = discipline
    }

    override fun getDisciplineByID(id: Int): Discipline {
        var discipline: Discipline? = null
        for (i in disciplines.indices) {
            discipline = disciplines[i]
            if (discipline.id == id) {
                return disciplines[i]
            }
        }
        throw NoSuchElementException()
    }
}
