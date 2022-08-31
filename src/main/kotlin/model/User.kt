package model

class User(val id: String, val username: String, var email: String, var password: String, var image: String, val posts: MutableList<Post> = mutableListOf(), val following: MutableList<User> = mutableListOf(), val followers: MutableList<User> = mutableListOf() ) {

    fun addPost(post: Post) {
        posts.add(post)
    }

    fun addOrRemoveFollow(user: User) {
        if (following.remove(user)) return
        following.add(user)
    }

    fun addOrRemoveFollower(user: User) {
        if (followers.remove(user)) return
        followers.add(user)
    }

}