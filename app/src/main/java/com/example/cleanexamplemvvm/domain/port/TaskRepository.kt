package com.example.cleanexamplemvvm.domain.port

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.entity.Task

interface TaskRepository {
    fun create(task: Task): Task
    fun findByDiscipline(discipline: Discipline): List<Task>
    fun update(task: Task): Task
    fun getTasks(): List<Task>
    fun getUnclosedTasks(): List<Task>
    fun delete(task: Task): Boolean
}
