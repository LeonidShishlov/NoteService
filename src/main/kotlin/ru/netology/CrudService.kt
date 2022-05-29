package ru.netology

interface CrudService<E> {
    fun add(entity: E): Int
    fun delete(id: Int)
    fun edit(entity: E)
    fun read(): List<E>
    fun getById(id: Int): E
    fun restore(id: Int)
}