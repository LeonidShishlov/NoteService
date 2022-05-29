package ru.netology

data class Comment(
    val id: Int = 0,
    val noteId: Int,
    val ownerId: Int = 0,
    val replyTo: Int = 0,
    val commentId: Int,
    val message: String,

) {var itIsDeleted: Boolean = false}