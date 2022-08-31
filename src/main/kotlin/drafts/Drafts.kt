package drafts

class DraftPost(var title: String, var description: String, var video: String)
class DraftUser(var username: String, var email: String, var password: String, var image: String)
class DraftEditUser(var email: String, var password: String, var image: String)
class DraftComment(var text: String)