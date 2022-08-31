package service

import drafts.DraftComment
import drafts.DraftEditUser
import drafts.DraftPost
import drafts.DraftUser
import exceptions.PostException
import exceptions.UserException
import model.*

class TiktokSystem {
    val users = mutableListOf<User>()
    val posts = mutableListOf<Post>()
    val comments = mutableListOf<Comment>()
    private val idGenerator = IdGenerator()

    fun addPost(idUser: String, draftPost: DraftPost): Post {
        val user = getUser(idUser)
        val post = Post(idGenerator.nextPostId(), user, draftPost.title, draftPost.description, draftPost.video)
        user.addPost(post)
        posts.add(post)
        return post
    }

    fun editPost(idPost: String, idUser: String, editPost: DraftPost): Post {
        val post = getPost(idPost, idUser)
        post.title = editPost.title
        post.description = editPost.description
        post.video = editPost.video
        return post
    }

    fun addUser(user: DraftUser): User {
        checkExistingNewUser(user)
        val newUser = User(idGenerator.nextUserId(), user.username, user.email, user.password, user.image)
        users.add(newUser)
        return newUser
    }

    fun editUser(idUser: String, editUser: DraftEditUser): User {
        val user = getUser(idUser)
        user.email = editUser.email
        user.password = editUser.password
        user.image = editUser.image
        return user
    }

    fun getLatestPosts(): List<Post> {
        return posts.reversed().take(10)
    }

    fun getTimeline(userId: String): List<Post> {
        val user = getUser(userId)
        return posts.reversed().filter { post -> user.following.any { it.id == post.user.id } }.take(10)
    }

    fun getRecommendAccounts(): List<User> {
        return getRecommendAccounts(listOf())
    }

    fun getRecommendAccounts(idUser: String): List<User> {
        val user = this.getUser(idUser)
        val usersToRemove = user.following
        usersToRemove.add(user)
        return getRecommendAccounts(this.getUser(idUser).following)
    }

    private fun getRecommendAccounts(usersToRemove: List<User>): List<User> {
        val allUsers = this.users.sortedByDescending { it.followers.size }.toMutableList()
        allUsers.removeAll(usersToRemove)
        return allUsers.take(10)
    }

    fun getTopTrends(): List<String> {
        val regex = Regex("#\\w+")
        val allTrends = posts.flatMap { post -> regex.findAll(post.description).flatMap { it.groupValues } }.groupBy { it }
        val sortedTrends = allTrends.toList().sortedByDescending { it.second.size }
        return sortedTrends.map { it.first }.take(10)
    }

    fun getTrend(trend: String): List<Post> {
        val regex = Regex("""${trend}\b""")
        return posts.filter { post -> post.description.contains(regex) }
    }

    fun search(text: String): SearchResult {
        val posts = posts.filter { it.title.contains(text) || it.description.contains(text) }
        val users = users.filter { it.username.contains(text) }
        return SearchResult(users, posts)
    }

    fun addComment(idUser: String, idPost: String, draftComment: DraftComment): Post {
        val user = getUser(idUser)
        val post = getPost(idPost)
        val comment = Comment(idGenerator.nextCommentId(), user, post, draftComment.text)
        post.addComment(comment)
        comments.add(comment)
        return post
    }

    fun updateLike(idUser: String, idPost: String): Post {
        val user = getUser(idUser)
        val post = getPost(idPost)
        post.addOrRemoveLike(user)
        return post
    }

    fun updateFollow(idUser: String, idOfUserToFollow: String): User {
        val user = getUser(idUser)
        val userToFollow = getUser(idOfUserToFollow)
        user.addOrRemoveFollow(userToFollow)
        userToFollow.addOrRemoveFollower(user)
        return user
    }

    fun getUser(idUser: String): User {
        return users.find { it.id == idUser } ?: throw UserException("Not found user id")
    }

    fun getPost(idPost: String): Post {
        return posts.find { it.id == idPost } ?: throw PostException("Not found post id")
    }

    private fun getPost(idPost: String, idUser: String): Post {
        val user = getUser(idUser)
        val post = getPost(idPost)
        if (post.user.id == user.id) return post else throw PostException("Not found post id")
    }

    private fun checkExistingNewUser(user: DraftUser) {
        if (users.any { it.username === user.username }) throw UserException("Username is in used")
        if (users.any { it.email === user.email }) throw UserException("Email is in used")
    }
}