# UNQ » UIs » Dominio » Tiktok
[![](https://jitpack.io/v/unq-ui/tiktok-model.svg)](https://jitpack.io/#unq-ui/tiktok-model)

Construcción de Interfaces de Usuario, Universidad Nacional de Quilmes.

### Dependencia

Agregar el repositorio:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Agregar la dependencia:

```xml
<dependency>
    <groupId>com.github.unq-ui</groupId>
    <artifactId>tiktok-model</artifactId>
    <version>v1.0.6</version>
</dependency>
```

### Interfaz de uso

```kotlin
class TiktokSystem {

    val users = mutableListOf<User>()
    val posts = mutableListOf<Post>()
    val comments = mutableListOf<Comment>()

    /*
        * Login to the system
        * @param username the username of the user
        * @param password the password of the user
        * @return the user that has been logged in
    */
    fun login(username: String, password: String): User

    /*
        * Add a new post to the system
        * @param idUser the id of the user that is adding the post
        * @param draftPost the post that is going to be added
        * @return the post that has been added
        * @throws UserException if the user is not found
    */
    fun addPost(idUser: String, draftPost: DraftPost): Post

    /*
        * Edit a post
        * @param idPost the id of the post that is going to be edited
        * @param idUser the id of the user that is going to edit the post
        * @param editPost the new post that is going to replace the old one
        * @return the post that has been edited
        * @throws PostException if the post is not found
        * @throws UserException if the user is not found
    */
    fun editPost(idPost: String, idUser: String, editPost: DraftPost): Post

    /*
        * Add new user to the system
        * @param user the user that is going to be added
        * @return the user that has been added
        * @throws UserException if the username or email is already in use
    */
    fun addUser(user: DraftUser): User

    /*
        * Edit a user
        * @param idUser the id of the user that is going to be edited
        * @param editUser the new user that is going to replace the old one
        * @return the user that has been edited
        * @throws UserException if the user is not found
    */
    fun editUser(idUser: String, editUser: DraftEditUser): User

    /*
        * Get the latest posts
        * @return the 10 latest posts
    */
    fun getLatestPosts(): List<Post>

    /*
        * Get the timeline of a user
        * @param userId the id of the user
        * @return the 10 latest posts of the user and the users that the user is following
    */
    fun getTimeline(userId: String): List<Post>

    /*
        * Get users can be recommended to follow
        * @param idUser the id of the user
        * @return the 10 users that can be recommended to follow
        * @throws UserException if the user is not found
    */
    fun getRecommendAccounts(idUser: String): List<User>

    /*
        * Get the top trends
        * @return the 10 top trends
    */
    fun getTopTrends(): List<String>

    /*
        * Get the posts of a trend
        * @param trend the trend that is going to be searched
        * @return the posts that contain the trend
    */
    fun getTrend(trend: String): List<Post>

    /*
        * Search for users and posts
        * @param text the text that is going to be searched
        * @return the users and posts that contain the text    
    */
    fun search(text: String): SearchResult
    /*
        * Add a comment to a post
        * @param idUser the id of the user that is going to add the comment
        * @param idPost the id of the post that is going to receive the comment
        * @param draftComment the comment that is going to be added
        * @return the post that has been commented
        * @throws UserException if the user is not found
        * @throws PostException if the post is not found
    */
    fun addComment(idUser: String, idPost: String, draftComment: DraftComment): Post

    /*
        * Update the like of a post
        * @param idUser the id of the user that is going to like the post
        * @param idPost the id of the post that is going to receive the like
        * @return the post that has been liked
        * @throws UserException if the user is not found
        * @throws PostException if the post is not found
    */
    fun updateLike(idUser: String, idPost: String): Post

    /*
        * Update the follow of a user
        * @param idUser the id of the user that is going to follow another user
        * @param idOfUserToFollow the id of the user that is going to be followed
        * @return the user that has been followed
        * @throws UserException if the user is not found
    */
    fun updateFollow(idUser: String, idOfUserToFollow: String): User

    /*
        * Get the user by id
        * @param idUser the id of the user
        * @return the user that has the id
        * @throws UserException if the user is not found
    */
    fun getUser(idUser: String): User

    /*
        * Get the post by id
        * @param idPost the id of the post
        * @return the post that has the id
        * @throws PostException if the post is not found
    */
    fun getPost(idPost: String): Post
}
```


### Iniciar el sistema con datos

```kotlin
val service = Bootstrap().getService()
```

[Ver usuarios del sistema](https://github.com/unq-ui/tiktok-model/blob/master/src/main/kotlin/bootstrap/bootstrap.kt)

### Modelo

```kotlin
class User(
  val id: String,
  val username: String,
  var email: String,
  var password: String,
  var image: String,
  val posts: MutableList<Post>,
  val following: MutableList<User>,
  val followers: MutableList<User>
)

class Post(
  val id: String,
  val user: User,
  var title: String,
  var description: String,
  var video: String,
  val comments: MutableList<Comment>,
  val likes: MutableList<User>
)

class Comment(
  val id: String,
  val user: User,
  val post: Post,
  val text: String
)

class SearchResult(
  val users: List<User>,
  val posts: List<Post>
)
```


# Requerimientos

* El sistema tiene que permitir agregar/editar Posts.

* Un `Post` cuenta con:
  * Un id unico (con formato "p_{numero}").
  * Un titulo (no puede ser vacio)
  * Una descripcion (no puede ser vacia).
  * Un video (que es una url) (no puede ser vacia).
  * Comentarios.

* Un `Comment` cuenta con:
  * Un id unico (con formato "c_{numero}").
  * Un usuario (que tiene que pertenecer al sistema)
  * Un Post (que tiene que pertenecer al sistema)
  * Un texto (que no puede ser vacio)

* Un `User` cuenta con:
  * Un id unico (con formato "u_{numero}").
  * Un username (que no puede estar repetido en la aplicacion y no puede ser vacio).
  * Una contraseña (que no puede ser vacia).
  * Un email (que no puede estar repetido en la aplicacion y no puede ser vacio).
  * Un listado de posts.

* TODA interaccion tiene que pasar por TiktokSystem (con la interfaz definida previamente).

* El TiktokSystem es el encargado de setear los ids de cada elemento que se agrega el sistema.
  * Para simplificar se utilizan objetos draft

```kotlin
class DraftPost(
  var title: String,
  var description: String,
  var video: String
)

class DraftUser(
  var username: String,
  var email: String,
  var password: String,
  var image: String
)

class DraftEditUser(
  var email: String,
  var password: String,
  var image: String
)

class DraftComment(
  var text: String
)
```
