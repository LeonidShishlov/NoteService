package ru.netology

object CommentService: CrudService<Comment> {
    private var comments = ArrayList<Comment>()

    override fun add(entity: Comment): Int {
        val id = (comments.size + 1)
        comments.add(entity.copy(id = id))

        return id
    }

    override fun delete(id: Int) {
        comments.filter{it.id == id}[0].itIsDeleted= true
    }

    override fun edit(entity: Comment) {
        comments.remove(getById(entity.id))
        comments.add(entity.copy(message = entity.message))
    }

    override fun read(): List<Comment> {
        return comments.filter{!it.itIsDeleted}
    }

    override fun getById(id: Int): Comment {
        return comments.filter{it.id == id}[0]
    }

    override fun restore(id: Int) {
        comments.filter{it.id == id}[0].itIsDeleted = false
    }

    fun read(note: Note): List<Comment> {
        return comments.filter{!it.itIsDeleted && it.noteId == note.id}
    }
}