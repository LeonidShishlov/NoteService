package ru.netology

object NoteService: CrudService<Note> {
    private val notes = mutableListOf<Note>()

    override fun add(entity: Note): Int {
        val id = (notes.size + 1)
        notes.add(entity.copy(id = id))

        return id
    }

    override fun delete(id: Int) {
        notes.filter{it.id == id}[0].itIsDeleted = true
    }

    override fun edit(entity: Note) {
        notes.remove(getById(entity.id))
        notes.add(entity.copy(title = entity.title, text = entity.text))
    }

    override fun read(): List<Note> {
        return notes.filter{!it.itIsDeleted}
    }

    override fun getById(id: Int): Note {
        return notes.filter{it.id == id}[0]
    }

    override fun restore(id: Int) {
        notes.filter{it.id == id}[0].itIsDeleted = false
    }

    fun createComment(noteId: Int, ownerId: Int, replyTo: Int, commentId: Int, message: String): Int {
        val comment = Comment(id = 0, noteId = noteId, ownerId = ownerId, replyTo = replyTo, commentId = commentId , message = message)
        return CommentService.add(comment)
    }

    fun deleteComment(id: Int) {
        CommentService.delete(id)
    }

    fun editComment(id: Int, ownerId: Int, message: String) {
        val comment = CommentService.getById(id).copy(ownerId = ownerId, message = message)
        CommentService.edit(comment)
    }

    fun getComments(noteId: Int): List<Comment> {
        return CommentService.read(getById(noteId))
    }

}