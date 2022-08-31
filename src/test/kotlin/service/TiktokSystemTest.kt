package service

import drafts.DraftComment
import drafts.DraftEditUser
import drafts.DraftPost
import drafts.DraftUser
import exceptions.PostException
import exceptions.UserException
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class TiktokSystemTest {

    @Test
    fun addUserTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        val user = system.users[0]
        assertEquals(user.id, "u_1")
        assertEquals(user.username, "user")
        assertEquals(user.email, "user@email.com")
        assertEquals(user.password, "user")
        assertEquals(user.image, "image")
    }

    @Test
    fun addUserWithSameUsernameTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertThrows<UserException> {
            system.addUser(DraftUser("user", "user1@email.com", "user", "image"))
        }
    }

    @Test
    fun addUserWithSameEmailTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertThrows<UserException> {
            system.addUser(DraftUser("user1", "user@email.com", "user", "image"))
        }
    }

    @Test
    fun editUserTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        val user = system.editUser("u_1", DraftEditUser("user1@email.com", "pass", "image2"))
        assertEquals(user.id, "u_1")
        assertEquals(user.username, "user")
        assertEquals(user.email, "user1@email.com")
        assertEquals(user.password, "pass")
        assertEquals(user.image, "image2")
    }

    @Test
    fun editUserWithWrongIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertThrows<UserException> {
            system.editUser("u_0", DraftEditUser("user1@email.com", "pass", "image2"))
        }
    }

    @Test
    fun updateFollowTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user2", "image2"))
        assertEquals(system.users.size, 2)
        assertEquals(system.getUser("u_1").following.size, 0)
        assertEquals(system.getUser("u_2").followers.size, 0)
        val user = system.updateFollow("u_1", "u_2")
        assertEquals(user.following.size, 1)
        assertEquals(system.getUser("u_2").following.size, 0)
        assertEquals(system.getUser("u_2").followers.size, 1)
    }

    @Test
    fun updateFollowTwoTimesTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user2", "image2"))
        assertEquals(system.users.size, 2)
        assertEquals(system.getUser("u_1").following.size, 0)
        val user = system.updateFollow("u_1", "u_2")
        assertEquals(user.following.size, 1)
        assertEquals(system.getUser("u_2").following.size, 0)
        assertEquals(system.getUser("u_2").followers.size, 1)

        assertEquals(system.getUser("u_1").following.size, 1)
        val user2 = system.updateFollow("u_1", "u_2")
        assertEquals(user2.following.size, 0)
        assertEquals(system.getUser("u_2").following.size, 0)
        assertEquals(system.getUser("u_2").followers.size, 0)
    }

    @Test
    fun updateFollowWithWrongUserIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user2", "image2"))
        assertEquals(system.users.size, 2)

        assertThrows<UserException> {
            system.updateFollow("u_10", "u_2")
        }
    }

    @Test
    fun updateFollowWithWrongIdOfUserToFollowTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user2", "image2"))
        assertEquals(system.users.size, 2)

        assertThrows<UserException> {
            system.updateFollow("u_1", "u_20")
        }
    }

    @Test
    fun addPostTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertEquals(system.posts.size, 0)
        val post = system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)
        val user = system.getUser("u_1")
        assertEquals(post.user, user)
        assertEquals(post.id, "p_1")
        assertEquals(post.title, "title")
        assertEquals(post.description, "description")
        assertEquals(post.video, "video")

        assertEquals(user.posts.size, 1)

    }

    @Test
    fun addPostWithWrongUserIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertThrows<UserException> {
            system.addPost("u_10", DraftPost("title", "description", "video"))
        }
    }

    @Test
    fun getPostTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertEquals(system.posts.size, 0)
        val post = system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        val getPost = system.getPost("p_1")
        assertEquals(post, getPost)
    }

    @Test
    fun getPostWithWrongIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertThrows<PostException> {
            system.getPost("p_10")
        }
    }

    @Test
    fun editPostTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        val post = system.editPost("p_1", "u_1", DraftPost("title2", "description2", "video2"))
        val user = system.getUser("u_1")
        assertEquals(post.user, user)
        assertEquals(post.id, "p_1")
        assertEquals(post.title, "title2")
        assertEquals(post.description, "description2")
        assertEquals(post.video, "video2")
    }

    @Test
    fun editPostWithWrongPostIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertThrows<PostException> {
            system.editPost("p_10", "u_1", DraftPost("title2", "description2", "video2"))
        }
    }

    @Test
    fun editPostWithWrongUserIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)

        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertThrows<UserException> {
            system.editPost("p_1", "u_10", DraftPost("title2", "description2", "video2"))
        }
    }

    @Test
    fun updateLikeTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        val originalPost = system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)
        assertEquals(originalPost.likes.size, 0)
        val post = system.updateLike("u_1", "p_1")
        assertEquals(post.likes.size, 1)
        assertEquals(post.likes[0], system.getUser("u_1"))
    }

    @Test
    fun updateLikeTwoTimesTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        val originalPost = system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)
        assertEquals(originalPost.likes.size, 0)
        val post = system.updateLike("u_1", "p_1")
        assertEquals(post.likes.size, 1)
        assertEquals(post.likes[0], system.getUser("u_1"))

        val post1 = system.updateLike("u_1", "p_1")
        assertEquals(post1.likes.size, 0)
    }

    @Test
    fun updateLikeWithWrongUserId() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertThrows<UserException> {
            system.updateLike("u_10", "p_1")
        }
    }

    @Test
    fun updateLikeWithWrongPostId() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertThrows<PostException> {
            system.updateLike("u_1", "p_10")
        }
    }

    @Test
    fun addCommentTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertEquals(system.comments.size, 0)
        val post = system.addComment("u_1", "p_1", DraftComment("Comment"))
        assertEquals(system.comments.size, 1)
        assertEquals(post.comments.size, 1)

        val comment = post.comments[0]
        assertEquals(comment.post, post)
        assertEquals(comment.user, system.getUser("u_1"))
        assertEquals(comment.id, "c_1")
        assertEquals(comment.text, "Comment")
    }

    @Test
    fun addCommentWithWrongUserIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertEquals(system.comments.size, 0)
        assertThrows<UserException> {
            system.addComment("u_10", "p_1", DraftComment("Comment"))
        }
    }

    @Test
    fun addCommentWithWrongPostIdTest() {
        val system = TiktokSystem()
        assertEquals(system.users.size, 0)
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        assertEquals(system.users.size, 1)
        assertEquals(system.posts.size, 0)
        system.addPost("u_1", DraftPost("title", "description", "video"))
        assertEquals(system.posts.size, 1)

        assertEquals(system.comments.size, 0)
        assertThrows<PostException> {
            system.addComment("u_1", "p_10", DraftComment("Comment"))
        }
    }

    @Test
    fun getRecommendAccountsTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user1", "user1@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user", "image"))
        system.addUser(DraftUser("user3", "user3@email.com", "user", "image"))
        system.addUser(DraftUser("user4", "user4@email.com", "user", "image"))
        system.addUser(DraftUser("user5", "user5@email.com", "user", "image"))
        system.addUser(DraftUser("user6", "user6@email.com", "user", "image"))
        system.addUser(DraftUser("user7", "user7@email.com", "user", "image"))
        system.addUser(DraftUser("user8", "user8@email.com", "user", "image"))
        system.addUser(DraftUser("user9", "user9@email.com", "user", "image"))
        system.addUser(DraftUser("user10", "user10@email.com", "user", "image"))
        system.addUser(DraftUser("user11", "user11@email.com", "user", "image"))
        system.addUser(DraftUser("user12", "user12@email.com", "user", "image"))
        system.addUser(DraftUser("user13", "user13@email.com", "user", "image"))
        system.addUser(DraftUser("user14", "user14@email.com", "user", "image"))

        system.updateFollow("u_1", "u_2")
        system.updateFollow("u_1", "u_3")
        system.updateFollow("u_1", "u_4")

        system.updateFollow("u_2", "u_3")
        system.updateFollow("u_2", "u_4")

        system.updateFollow("u_3", "u_4")

        val recommendedAccounts = system.getRecommendAccounts()
        assertEquals(recommendedAccounts.size, 10)
        assertEquals(recommendedAccounts[0].id, "u_4")
        assertEquals(recommendedAccounts[1].id, "u_3")
        assertEquals(recommendedAccounts[2].id, "u_2")
    }

    @Test
    fun getRecommendAccountsWithUserIdTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user1", "user1@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user", "image"))
        system.addUser(DraftUser("user3", "user3@email.com", "user", "image"))
        system.addUser(DraftUser("user4", "user4@email.com", "user", "image"))
        system.addUser(DraftUser("user5", "user5@email.com", "user", "image"))
        system.addUser(DraftUser("user6", "user6@email.com", "user", "image"))
        system.addUser(DraftUser("user7", "user7@email.com", "user", "image"))
        system.addUser(DraftUser("user8", "user8@email.com", "user", "image"))
        system.addUser(DraftUser("user9", "user9@email.com", "user", "image"))
        system.addUser(DraftUser("user10", "user10@email.com", "user", "image"))
        system.addUser(DraftUser("user11", "user11@email.com", "user", "image"))
        system.addUser(DraftUser("user12", "user12@email.com", "user", "image"))
        system.addUser(DraftUser("user13", "user13@email.com", "user", "image"))
        system.addUser(DraftUser("user14", "user14@email.com", "user", "image"))

        system.updateFollow("u_1", "u_2")
        system.updateFollow("u_1", "u_3")
        system.updateFollow("u_1", "u_4")

        system.updateFollow("u_2", "u_3")
        system.updateFollow("u_2", "u_4")

        system.updateFollow("u_3", "u_4")

        val recommendedAccounts = system.getRecommendAccounts("u_3")
        assertEquals(recommendedAccounts.size, 10)
        assertEquals(recommendedAccounts[0].id, "u_2")
    }

    @Test
    fun getRecommendAccountsWithWrongUserIdTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user1", "user1@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user", "image"))
        system.addUser(DraftUser("user3", "user3@email.com", "user", "image"))
        system.addUser(DraftUser("user4", "user4@email.com", "user", "image"))
        system.addUser(DraftUser("user5", "user5@email.com", "user", "image"))
        system.addUser(DraftUser("user6", "user6@email.com", "user", "image"))
        system.addUser(DraftUser("user7", "user7@email.com", "user", "image"))
        system.addUser(DraftUser("user8", "user8@email.com", "user", "image"))
        system.addUser(DraftUser("user9", "user9@email.com", "user", "image"))
        system.addUser(DraftUser("user10", "user10@email.com", "user", "image"))
        system.addUser(DraftUser("user11", "user11@email.com", "user", "image"))
        system.addUser(DraftUser("user12", "user12@email.com", "user", "image"))
        system.addUser(DraftUser("user13", "user13@email.com", "user", "image"))
        system.addUser(DraftUser("user14", "user14@email.com", "user", "image"))

        system.updateFollow("u_1", "u_2")
        system.updateFollow("u_1", "u_3")
        system.updateFollow("u_1", "u_4")

        system.updateFollow("u_2", "u_3")
        system.updateFollow("u_2", "u_4")

        system.updateFollow("u_3", "u_4")

        assertThrows<UserException> {
            system.getRecommendAccounts("u_30")
        }
    }

    @Test
    fun getAllTrendsTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe #jota", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #2pepe", "v"))
        val trends = system.getTopTrends()
        assertEquals(trends.size, 5)
        assertEquals(trends[0], "#pepe")
        assertEquals(trends[1], "#1pepe")
        assertEquals(trends[2], "#2pepe")
        assertEquals(trends[3], "#3pepe")
        assertEquals(trends[4], "#jota")
    }

    @Test
    fun getTrendsTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe #jota", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t1", "d #2pepe", "v"))
        val posts = system.getTrend("#pepe")
        assertEquals(posts.size, 5)
        assertEquals(posts[0].id, "p_1")
        assertEquals(posts[1].id, "p_6")
        assertEquals(posts[2].id, "p_7")
        assertEquals(posts[3].id, "p_8")
        assertEquals(posts[4].id, "p_12")
    }

    @Test
    fun getLatestPostsTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t2", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t3", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t4", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t5", "d", "v"))
        system.addPost("u_1", DraftPost("t6", "d #pepe #jota", "v"))
        system.addPost("u_1", DraftPost("t7", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t8", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t9", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t10", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t11", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t12", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t13", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t14", "d #2pepe", "v"))
        val posts = system.getLatestPosts()
        assertEquals(posts.size, 10)
        assertEquals(posts[0].title,"t14")
        assertEquals(posts[1].title,"t13")
        assertEquals(posts[9].title,"t5")
    }

    @Test
    fun getTimelineTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user1", "user1@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user", "image"))
        system.addUser(DraftUser("user4", "user4@email.com", "user", "image"))
        system.addPost("u_1", DraftPost("t1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("t2", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("t3", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("t4", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("t5", "d", "v"))
        system.addPost("u_3", DraftPost("t6", "d #pepe #jota", "v"))
        system.addPost("u_3", DraftPost("t7", "d #pepe", "v"))
        system.addPost("u_3", DraftPost("t8", "d #pepe", "v"))
        system.addPost("u_3", DraftPost("t9", "d #1pepe", "v"))
        system.addPost("u_3", DraftPost("t10", "d #2pepe", "v"))
        system.addPost("u_3", DraftPost("t11", "d #3pepe", "v"))
        system.addPost("u_3", DraftPost("t12", "d #pepe", "v"))
        system.addPost("u_3", DraftPost("t13", "d #1pepe", "v"))
        system.addPost("u_3", DraftPost("t14", "d #2pepe", "v"))
        system.updateFollow("u_2", "u_1")
        system.updateFollow("u_2", "u_3")
        val posts = system.getTimeline("u_2")
        assertEquals(posts.size, 10)
        assertEquals(posts[0].title,"t14")
        assertEquals(posts[1].title,"t13")
        assertEquals(posts[9].title,"t5")

        system.updateFollow("u_4", "u_3")
        val posts2 = system.getTimeline("u_4")
        assertEquals(posts2.size, 9)
        assertEquals(posts[0].title,"t14")
        assertEquals(posts[1].title,"t13")
        assertEquals(posts[8].title,"t6")
    }

    @Test
    fun searchTest() {
        var system = TiktokSystem()
        system.addUser(DraftUser("user", "user@email.com", "user", "image"))
        system.addUser(DraftUser("user1", "user1@email.com", "user", "image"))
        system.addUser(DraftUser("user2", "user2@email.com", "user", "image"))
        system.addUser(DraftUser("pepe", "user4@email.com", "user", "image"))
        system.addPost("u_1", DraftPost("ti1", "d #pepe", "v"))
        system.addPost("u_1", DraftPost("ti2", "d #1pepe", "v"))
        system.addPost("u_1", DraftPost("ti3", "d #2pepe", "v"))
        system.addPost("u_1", DraftPost("ti4", "d #3pepe", "v"))
        system.addPost("u_1", DraftPost("ti5", "d", "v"))
        system.addPost("u_3", DraftPost("us6", "d #pepe #jota", "v"))
        system.addPost("u_3", DraftPost("us7", "d #pepe", "v"))
        system.addPost("u_3", DraftPost("us8", "d #pepe", "v"))
        system.addPost("u_3", DraftPost("us9", "d #1pepe", "v"))
        system.addPost("u_3", DraftPost("t10", "d #2pepe", "v"))
        system.addPost("u_3", DraftPost("t11", "d #3pepe", "v"))
        system.addPost("u_3", DraftPost("t12", "d #pepe", "v"))
        system.addPost("u_3", DraftPost("t13", "d #1pepe", "v"))
        system.addPost("u_3", DraftPost("t14", "d #2pepe", "v"))

        val search = system.search("us")

        assertEquals(search.posts.size, 4)
        assertEquals(search.posts[0].title, "us6")
        assertEquals(search.posts[1].title, "us7")
        assertEquals(search.posts[2].title, "us8")
        assertEquals(search.posts[3].title, "us9")
        assertEquals(search.users.size, 3)
        assertEquals(search.users[0].username, "user")
        assertEquals(search.users[1].username, "user1")
        assertEquals(search.users[2].username, "user2")
    }
}