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

    /*
        * Login to the system
        * @param username the username of the user
        * @param password the password of the user
        * @return the user that has been logged in
    */
    fun login(username: String, password: String): User {
        return users.find { it.username == username && it.password == password } ?: throw UserException("User not found")
    }

    /*
        * Add a new post to the system
        * @param idUser the id of the user that is adding the post
        * @param draftPost the post that is going to be added
        * @return the post that has been added
        * @throws UserException if the user is not found
    */
    fun addPost(idUser: String, draftPost: DraftPost): Post {
        val user = getUser(idUser)
        val post = Post(idGenerator.nextPostId(), user, draftPost.title, draftPost.description, draftPost.video)
        user.addPost(post)
        posts.add(post)
        return post
    }

    /*
        * Edit a post
        * @param idPost the id of the post that is going to be edited
        * @param idUser the id of the user that is going to edit the post
        * @param editPost the new post that is going to replace the old one
        * @return the post that has been edited
        * @throws PostException if the post is not found
        * @throws UserException if the user is not found
    */
    fun editPost(idPost: String, idUser: String, editPost: DraftPost): Post {
        val post = getPost(idPost, idUser)
        post.title = editPost.title
        post.description = editPost.description
        post.video = editPost.video
        return post
    }

    /*
        * Add new user to the system
        * @param user the user that is going to be added
        * @return the user that has been added
        * @throws UserException if the username or email is already in use
    */
    fun addUser(user: DraftUser): User {
        checkExistingNewUser(user)
        val newUser = User(idGenerator.nextUserId(), user.username, user.email, user.password, user.image)
        users.add(newUser)
        return newUser
    }

    /*
        * Edit a user
        * @param idUser the id of the user that is going to be edited
        * @param editUser the new user that is going to replace the old one
        * @return the user that has been edited
        * @throws UserException if the user is not found
    */
    fun editUser(idUser: String, editUser: DraftEditUser): User {
        val user = getUser(idUser)
        user.email = editUser.email
        user.password = editUser.password
        user.image = editUser.image
        return user
    }

    /*
        * Get the latest posts
        * @return the 10 latest posts
    */
    fun getLatestPosts(): List<Post> {
        return posts.reversed().take(10)
    }

    /*
        * Get the timeline of a user
        * @param userId the id of the user
        * @return the 10 latest posts of the user and the users that the user is following
    */
    fun getTimeline(userId: String): List<Post> {
        val user = getUser(userId)
        return posts.reversed().filter { post -> user.following.any { it.id == post.user.id } }.take(10)
    }

    /*
        * Get users can be recommended to follow
        * @param idUser the id of the user
        * @return the 10 users that can be recommended to follow
        * @throws UserException if the user is not found
    */
    fun getRecommendAccounts(idUser: String): List<User> {
        val user = this.getUser(idUser)
        val usersToRemove = mutableListOf<User>()
        usersToRemove.addAll(user.following)
        usersToRemove.add(user)
        return getRecommendAccounts(usersToRemove)
    }

    private fun getRecommendAccounts(usersToRemove: List<User>): List<User> {
        val allUsers = this.users.sortedByDescending { it.followers.size }.toMutableList()
        allUsers.removeAll(usersToRemove)
        return allUsers.take(10)
    }

    /*
        * Get the top trends
        * @return the 10 top trends
    */
    fun getTopTrends(): List<String> {
        val regex = Regex("#\\w+")
        val allTrends = posts.flatMap { post -> regex.findAll(post.description).flatMap { it.groupValues } }.groupBy { it }
        val sortedTrends = allTrends.toList().sortedByDescending { it.second.size }
        return sortedTrends.map { it.first }.take(10)
    }

    /*
        * Get the posts of a trend
        * @param trend the trend that is going to be searched
        * @return the posts that contain the trend
    */
    fun getTrend(trend: String): List<Post> {
        val regex = Regex("""${trend}\b""")
        return posts.filter { post -> post.description.contains(regex) }
    }

    /*
        * Search for users and posts
        * @param text the text that is going to be searched
        * @return the users and posts that contain the text    
    */
    fun search(text: String): SearchResult {
        val posts = posts.filter { it.title.contains(text) || it.description.contains(text) }
        val users = users.filter { it.username.contains(text) }
        return SearchResult(users, posts)
    }

    /*
        * Add a comment to a post
        * @param idUser the id of the user that is going to add the comment
        * @param idPost the id of the post that is going to receive the comment
        * @param draftComment the comment that is going to be added
        * @return the post that has been commented
        * @throws UserException if the user is not found
        * @throws PostException if the post is not found
    */
    fun addComment(idUser: String, idPost: String, draftComment: DraftComment): Post {
        val user = getUser(idUser)
        val post = getPost(idPost)
        val comment = Comment(idGenerator.nextCommentId(), user, post, draftComment.text)
        post.addComment(comment)
        comments.add(comment)
        return post
    }

    /*
        * Update the like of a post
        * @param idUser the id of the user that is going to like the post
        * @param idPost the id of the post that is going to receive the like
        * @return the post that has been liked
        * @throws UserException if the user is not found
        * @throws PostException if the post is not found
    */
    fun updateLike(idUser: String, idPost: String): Post {
        val user = getUser(idUser)
        val post = getPost(idPost)
        post.addOrRemoveLike(user)
        return post
    }

    /*
        * Update the follow of a user
        * @param idUser the id of the user that is going to follow another user
        * @param idOfUserToFollow the id of the user that is going to be followed
        * @return the user that has been followed
        * @throws UserException if the user is not found
    */
    fun updateFollow(idUser: String, idOfUserToFollow: String): User {
        val user = getUser(idUser)
        val userToFollow = getUser(idOfUserToFollow)
        if (user.id == userToFollow.id) throw UserException("Can't follow yourself.")
        user.addOrRemoveFollow(userToFollow)
        userToFollow.addOrRemoveFollower(user)
        return user
    }

    /*
        * Get the user by id
        * @param idUser the id of the user
        * @return the user that has the id
        * @throws UserException if the user is not found
    */
    fun getUser(idUser: String): User {
        return users.find { it.id == idUser } ?: throw UserException("Not found user id")
    }

    /*
        * Get the post by id
        * @param idPost the id of the post
        * @return the post that has the id
        * @throws PostException if the post is not found
    */
    fun getPost(idPost: String): Post {
        return posts.find { it.id == idPost } ?: throw PostException("Not found post id")
    }

    private fun getPost(idPost: String, idUser: String): Post {
        val user = getUser(idUser)
        val post = getPost(idPost)
        if (post.user.id == user.id) return post else throw PostException("Not found post id")
    }

    private fun checkExistingNewUser(user: DraftUser) {
        if (users.any { it.username == user.username }) throw UserException("Username is in used")
        if (users.any { it.email == user.email }) throw UserException("Email is in used")
    }
}