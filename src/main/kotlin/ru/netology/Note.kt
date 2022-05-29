package ru.netology

data class Note(
    val id: Int = 0,
    val noteId: Int,
    val title: String,
    val text: String,
    val comments: MutableList<Comment> = mutableListOf(),
    var itIsDeleted: Boolean = false
    )