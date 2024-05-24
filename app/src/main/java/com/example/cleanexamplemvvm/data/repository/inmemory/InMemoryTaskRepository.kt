package com.example.cleanexamplemvvm.data.repository.inmemory

import com.example.cleanexamplemvvm.domain.entity.Discipline
import com.example.cleanexamplemvvm.domain.entity.Task
import com.example.cleanexamplemvvm.domain.port.TaskRepository
import java.text.DateFormat


class InMemoryTaskRepository : TaskRepository {
    private val tasks: MutableList<Task> = ArrayList()
    init{
        val discipline1 = Discipline(0, "ООП", false, 4)
        val discipline2 = Discipline(1, "Базы данных", false, 5)
        val task1 = Task(
            0,
            "Лаб.раб №1",
            false,
           6767,// DateFormat.getDateInstance(DateFormat.SHORT).parse("01.05.24")!!.time,
            discipline1
        )
        val task2 = Task(
            1,
            "Лаб.раб №2",
            true,
            565656,//DateFormat.getDateInstance(DateFormat.SHORT).parse("01.05.24")!!.time,
            discipline1
        )


        tasks.add(task1)
        tasks.add(task2)
        //tasks.add(task3)
    }
    override fun create(task: Task): Task {
        val id = tasks.size
        val newTask = Task(id, task.title, task.isClosed, task.deadline, task.discipline)
        tasks.add(newTask)

        return newTask
    }

    override fun findByDiscipline(discipline: Discipline): List<Task> {
        val finded: MutableList<Task> = ArrayList()
        for (task in tasks) {
            if (task.discipline.id == discipline.id) {
                finded.add(task)
            }
        }
        return finded
    }

    override fun update(task: Task): Task {
        val updatedTask = Task(task.id, task.title, task.isClosed, task.deadline, task.discipline)
        val oldTaskIndex = tasks.indexOf(task)
        tasks[oldTaskIndex] = updatedTask
        return updatedTask
    }

    override fun getTasks(): List<Task> {
        return tasks
    }

    override fun getUnclosedTasks(): List<Task> {
        val unclosedTasks: MutableList<Task> = ArrayList()
        for (i in tasks.indices) {
            if (!tasks[i].isClosed) {
                unclosedTasks.add(tasks[i])
            }
        }
        return unclosedTasks
    }

    override fun delete(task: Task): Boolean {
        tasks.remove(task)
        return tasks.remove(task)
    }
}
