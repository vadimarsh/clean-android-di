package com.example.cleanexamplemvvm.domain.entity

class Discipline(
    var id: Int,
    var name: String,
    var closed:Boolean = false,
    var semestr:Int = 0)
{
    override fun toString(): String {
        return "Discipline{" +
                "hash=" + super.toString() +
                "id=" + id +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", semestr=" + semestr +
                '}'
    }

    override fun equals(obj: Any?): Boolean {
        if (obj is Discipline) {
            if (id == obj.id) {
                return true
            }
        }
        return super.equals(obj)
    }


}