package com.example.cleanexamplemvvm.domain.entity

class Task(
    val id: Int,
    var title: String,
    var isClosed: Boolean,
    var deadline: Long,
    var discipline: Discipline
) {
    override fun toString(): String {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + isClosed +
                ", deadline=" + deadline +
                ", discipline=" + discipline +
                '}'
    }

    fun changeState() {
        isClosed = !isClosed
    }
}
