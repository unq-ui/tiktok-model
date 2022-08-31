package model

class Post(val id: String, val user: User, var title: String, var description: String, var video: String, val comments: MutableList<Comment> = mutableListOf(), val likes: MutableList<User> = mutableListOf()) {
    fun addComment(comment: Comment) {
        comments.add(comment)
    }

    fun addOrRemoveLike(user: User) {
        if (likes.remove(user)) return
        likes.add(user)
    }
}