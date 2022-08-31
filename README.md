# UNQ » UIs » Dominio » Rotten tomatoes

[![](https://jitpack.io/v/unq-ui/tiktok-model.svg)](https://jitpack.io/#unq-ui/tiktok-model)

Construcción de Interfaces de Usuario, Universidad Nacional de Quilmes.

## TP 2022s2

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
    <version>1.0.1</version>
</dependency>
```

### Interfaz de uso

```kotlin
class TiktokSystem {

  val users: MutableList<User>
  val posts: MutableList<Post>
  val comments: MutableList<Comment>
  
  @throw UserException (
    * El email se encuentra repetido.
    * El username se encuentra repetido.
  )
  fun addUser(user: DraftUser): User

  @throw UserException (
    * El idUser no existe en el sistema.
  )
  fun editUser(idUser: String, editUser: DraftEditUser): User

  @throw UserException (
    * Si el username y la password no encuentra un resultado
  )
  fun login(username: String, password: String): User
  
  @throw UserException (
    * El idUser no existe en el sistema.
  )
  fun getUser(idUser: String): User


  @throw UserException (
    * Si el idUser no existe
  )
  fun addPost(idUser: String, draftPost: DraftPost): Post
  
  @throw UserException (
    * El idUser no existe en el sistema.
  )
  @throw PostException (
    * El idPost no existe en el sistema.
  )
  fun editPost(idPost: String, idUser: String, editPost: DraftPost): Post
  
 
  @throw PostException (
    * El idPost no existe en el sistema.
  )
  fun getPost(idPost: String): Post

  @throw UserException (
    * El idUser no existe en el sistema.
  )
  @throw PostException (
    * El idPost no existe en el sistema.
  )
  fun addComment(idUser: String, idPost: String, draftComment: DraftComment): Post
  
  @throw UserException (
    * El idUser no existe en el sistema.
  )
  @throw PostException (
    * El idPost no existe en el sistema.
  )
  fun updateLike(idUser: String, idPost: String): Post
  
  @throw UserException (
    * El idUser o el idOfUserToFollow no existe en el sistema.
  )
  fun updateFollow(idUser: String, idOfUserToFollow: String): User

  fun search(text: String): SearchResult
  
  fun getTrend(trend: String): List<Post>
  
  fun getTopTrends(): List<String>
  
  fun getRecommendAccounts(idUser: String): List<User>
  
  fun getRecommendAccounts(): List<User>
  
  fun getTimeline(userId: String): List<Post>

  fun getLatestPosts(): List<Post>

}
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
class DraftPost(var title: String, var description: String, var video: String)
class DraftUser(var username: String, var email: String, var password: String, var image: String)
class DraftEditUser(var email: String, var password: String, var image: String)
class DraftComment(var text: String)
```
