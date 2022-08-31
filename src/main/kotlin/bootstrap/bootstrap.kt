package bootstrap

import drafts.DraftComment
import drafts.DraftPost
import drafts.DraftUser
import service.TiktokSystem
import kotlin.random.Random

class Bootstrap {

    private val random = Random(100)

    private fun addUsers(tiktokSystem: TiktokSystem) {
        tiktokSystem.addUser(DraftUser("jania", "jania@gmail.com", "jania", "https://robohash.org/eumutvoluptatem.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("tiebold", "tiebold@gmail.com", "tiebold", "https://robohash.org/eumquoasperiores.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("corella", "corella@gmail.com", "corella", "https://robohash.org/essedebitisneque.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("curry", "curry@gmail.com", "curry", "https://robohash.org/quidempariaturquaerat.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("berny", "berny@gmail.com", "berny", "https://robohash.org/sitquisat.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("chip", "chip@gmail.com", "chip", "https://robohash.org/aconsequatureos.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("sandie", "sandie@gmail.com", "sandie", "https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("nye", "nye@gmail.com", "nye", "https://robohash.org/adipisciinillo.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("tallia", "tallia@gmail.com", "tallia", "https://robohash.org/nonharumautem.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("ashlen", "ashlen@gmail.com", "ashlen", "https://robohash.org/corruptimaximetotam.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("woodman", "woodman@gmail.com", "woodman", "https://robohash.org/temporedolorumunde.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("kacie", "kacie@gmail.com", "kacie", "https://robohash.org/veritatisiurevoluptatem.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("des", "des@gmail.com", "des", "https://robohash.org/omnispossimusprovident.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("adrienne", "adrienne@gmail.com", "adrienne", "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("rebecka", "rebecka@gmail.com", "rebecka", "https://robohash.org/voluptatedoloremut.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("emilia", "emilia@gmail.com", "emilia", "https://robohash.org/aperiaminmolestiae.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("mallorie", "mallorie@gmail.com", "mallorie", "https://robohash.org/quiquasinihil.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("octavia", "octavia@gmail.com", "octavia", "https://robohash.org/quidebitisquis.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("palmer", "palmer@gmail.com", "palmer", "https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("nicko", "nicko@gmail.com", "nicko", "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("juan", "juan@gmail.com", "juan", "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("rodrigo", "rodrigo@gmail.com", "rodrigo", "https://robohash.org/voluptatedoloremut.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("jesus", "jesus@gmail.com", "jesus", "https://robohash.org/aperiaminmolestiae.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("pepe", "pepe@gmail.com", "pepe", "https://robohash.org/quiquasinihil.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("martin", "martin@gmail.com", "martin", "https://robohash.org/quidebitisquis.bmp?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("ines", "ines@gmail.com", "ines", "https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("flor", "flor@gmail.com", "flor", "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("a", "a@gmail.com", "a", "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("b", "b@gmail.com", "b", "https://robohash.org/corruptimaximetotam.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("c", "c@gmail.com", "c", "https://robohash.org/quidempariaturquaerat.png?size=50x50&set=set1"))
        tiktokSystem.addUser(DraftUser("Saniya", "Saniya@gmail.com", "Saniya", "https://images.pexels.com/photos/399772/pexels-photo-399772.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Danika", "Danika@gmail.com", "Danika", "https://images.pexels.com/photos/737586/pexels-photo-737586.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Pheobe", "Pheobe@gmail.com", "Pheobe", "https://images.pexels.com/photos/2690323/pexels-photo-2690323.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Calum", "Calum@gmail.com", "Calum", "https://images.pexels.com/photos/11971069/pexels-photo-11971069.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Sue", "Sue@gmail.com", "Sue", "https://images.pexels.com/photos/11876794/pexels-photo-11876794.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Rami", "Rami@gmail.com", "Rami", "https://images.pexels.com/photos/10980266/pexels-photo-10980266.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Kathryn", "Kathryn@gmail.com", "Kathryn", "https://images.pexels.com/photos/9069288/pexels-photo-9069288.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Elyse", "Elyse@gmail.com", "Elyse", "https://images.pexels.com/photos/10714133/pexels-photo-10714133.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Sarah-Jayne", "Sarah-Jayne@gmail.com", "Sarah-Jayne", "https://images.pexels.com/photos/12051955/pexels-photo-12051955.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Jarred", "Jarred@gmail.com", "Jarred", "https://images.pexels.com/photos/11589670/pexels-photo-11589670.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Arbaaz", "Arbaaz@gmail.com", "Arbaaz", "https://images.pexels.com/photos/1030870/pexels-photo-1030870.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Soraya", "Soraya@gmail.com", "Soraya", "https://images.pexels.com/photos/3568518/pexels-photo-3568518.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Kelsi", "Kelsi@gmail.com", "Kelsi", "https://images.pexels.com/photos/3807758/pexels-photo-3807758.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Phebe", "Phebe@gmail.com", "Phebe", "https://images.pexels.com/photos/938580/pexels-photo-938580.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Nimra", "Nimra@gmail.com", "Nimra", "https://images.pexels.com/photos/789555/pexels-photo-789555.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Matei", "Matei@gmail.com", "Matei", "https://images.pexels.com/photos/194917/pexels-photo-194917.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Elise", "Elise@gmail.com", "Elise", "https://images.pexels.com/photos/1317712/pexels-photo-1317712.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Shaquille", "Shaquille@gmail.com", "Shaquille", "https://images.pexels.com/photos/1220757/pexels-photo-1220757.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Yousif", "Yousif@gmail.com", "Yousif", "https://images.pexels.com/photos/3334070/pexels-photo-3334070.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Mckenzie", "Mckenzie@gmail.com", "Mckenzie", "https://images.pexels.com/photos/6152103/pexels-photo-6152103.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Leticia", "Leticia@gmail.com", "Leticia", "https://images.pexels.com/photos/57901/pexels-photo-57901.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Anas", "Anas@gmail.com", "Anas", "https://images.pexels.com/photos/2609925/pexels-photo-2609925.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Levi", "Levi@gmail.com", "Levi", "https://images.pexels.com/photos/3876394/pexels-photo-3876394.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Kaycee", "Kaycee@gmail.com", "Kaycee", "https://images.pexels.com/photos/9786/pexels-photo.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Caoimhe", "Caoimhe@gmail.com", "Caoimhe", "https://images.pexels.com/photos/4609046/pexels-photo-4609046.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Alissa", "Alissa@gmail.com", "Alissa", "https://images.pexels.com/photos/1526814/pexels-photo-1526814.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Maleeha", "Maleeha@gmail.com", "Maleeha", "https://images.pexels.com/photos/426976/pexels-photo-426976.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Doris", "Doris@gmail.com", "Doris", "https://images.pexels.com/photos/4412934/pexels-photo-4412934.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Elissa", "Elissa@gmail.com", "Elissa", "https://images.pexels.com/photos/5990737/pexels-photo-5990737.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Elinor", "Elinor@gmail.com", "Elinor", "https://images.pexels.com/photos/2694040/pexels-photo-2694040.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Henley", "Henley@gmail.com", "Henley", "https://images.pexels.com/photos/2657669/pexels-photo-2657669.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Kaylem", "Kaylem@gmail.com", "Kaylem", "https://images.pexels.com/photos/2766408/pexels-photo-2766408.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Lainey", "Lainey@gmail.com", "Lainey", "https://images.pexels.com/photos/3301625/pexels-photo-3301625.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Cora", "Cora@gmail.com", "Cora", "https://images.pexels.com/photos/2858374/pexels-photo-2858374.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Taylor", "Taylor@gmail.com", "Taylor", "https://images.pexels.com/photos/12295663/pexels-photo-12295663.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Gary", "Gary@gmail.com", "Gary", "https://images.pexels.com/photos/335221/pexels-photo-335221.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Fay", "Fay@gmail.com", "Fay", "https://images.pexels.com/photos/792725/pexels-photo-792725.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Hamish", "Hamish@gmail.com", "Hamish", "https://images.pexels.com/photos/994164/pexels-photo-994164.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Zakaria", "Zakaria@gmail.com", "Zakaria", "https://images.pexels.com/photos/1105353/pexels-photo-1105353.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Beauden", "Beauden@gmail.com", "Beauden", "https://images.pexels.com/photos/137702/pexels-photo-137702.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Ed", "Ed@gmail.com", "Ed", "https://images.pexels.com/photos/2894944/pexels-photo-2894944.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Gloria", "Gloria@gmail.com", "Gloria", "https://images.pexels.com/photos/3459967/pexels-photo-3459967.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Pearl", "Pearl@gmail.com", "Pearl", "https://images.pexels.com/photos/2738919/pexels-photo-2738919.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Aryan", "Aryan@gmail.com", "Aryan", "https://images.pexels.com/photos/2269872/pexels-photo-2269872.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Alaina", "Alaina@gmail.com", "Alaina", "https://images.pexels.com/photos/3058391/pexels-photo-3058391.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Fern", "Fern@gmail.com", "Fern", "https://images.pexels.com/photos/3119215/pexels-photo-3119215.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Shahid", "Shahid@gmail.com", "Shahid", "https://images.pexels.com/photos/6744887/pexels-photo-6744887.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Jarod", "Jarod@gmail.com", "Jarod", "https://images.pexels.com/photos/1270076/pexels-photo-1270076.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Keane", "Keane@gmail.com", "Keane", "https://images.pexels.com/photos/1076240/pexels-photo-1076240.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Koby", "Koby@gmail.com", "Koby", "https://images.pexels.com/photos/994173/pexels-photo-994173.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Bernadette", "Bernadette@gmail.com", "Bernadette", "https://images.pexels.com/photos/1030943/pexels-photo-1030943.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Abdallah", "Abdallah@gmail.com", "Abdallah", "https://images.pexels.com/photos/3098619/pexels-photo-3098619.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Nojus", "Nojus@gmail.com", "Nojus", "https://images.pexels.com/photos/3750717/pexels-photo-3750717.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Haleema", "Haleema@gmail.com", "Haleema", "https://images.pexels.com/photos/35160/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Nazifa", "Nazifa@gmail.com", "Nazifa", "https://images.pexels.com/photos/1820559/pexels-photo-1820559.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Sophie", "Sophie@gmail.com", "Sophie", "https://images.pexels.com/photos/2118483/pexels-photo-2118483.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Polly", "Polly@gmail.com", "Polly", "https://images.pexels.com/photos/2240772/pexels-photo-2240772.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Francesca", "Francesca@gmail.com", "Francesca", "https://images.pexels.com/photos/2613458/pexels-photo-2613458.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Daanyaal", "Daanyaal@gmail.com", "Daanyaal", "https://images.pexels.com/photos/1493111/pexels-photo-1493111.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Zoe", "Zoe@gmail.com", "Zoe", "https://images.pexels.com/photos/1700656/pexels-photo-1700656.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Emir", "Emir@gmail.com", "Emir", "https://images.pexels.com/photos/2372937/pexels-photo-2372937.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Isobelle", "Isobelle@gmail.com", "Isobelle", "https://images.pexels.com/photos/1937434/pexels-photo-1937434.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Hayden", "Hayden@gmail.com", "Hayden", "https://images.pexels.com/photos/179908/pexels-photo-179908.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Betsy", "Betsy@gmail.com", "Betsy", "https://images.pexels.com/photos/268086/pexels-photo-268086.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Ezmae", "Ezmae@gmail.com", "Ezmae", "https://images.pexels.com/photos/2613461/pexels-photo-2613461.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Harun", "Harun@gmail.com", "Harun", "https://images.pexels.com/photos/2224424/pexels-photo-2224424.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Efan", "Efan@gmail.com", "Efan", "https://images.pexels.com/photos/2416871/pexels-photo-2416871.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Jeanne", "Jeanne@gmail.com", "Jeanne", "https://images.pexels.com/photos/940585/pexels-photo-940585.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Abdurrahman", "Abdurrahman@gmail.com", "Abdurrahman", "https://images.pexels.com/photos/3613388/pexels-photo-3613388.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Richard", "Richard@gmail.com", "Richard", "https://images.pexels.com/photos/35990/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Abubakr", "Abubakr@gmail.com", "Abubakr", "https://images.pexels.com/photos/228842/pexels-photo-228842.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Riley-James", "Riley-James@gmail.com", "Riley-James", "https://images.pexels.com/photos/1447885/pexels-photo-1447885.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Nabilah", "Nabilah@gmail.com", "Nabilah", "https://images.pexels.com/photos/99820/pexels-photo-99820.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Nina", "Nina@gmail.com", "Nina", "https://images.pexels.com/photos/1524414/pexels-photo-1524414.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Giselle", "Giselle@gmail.com", "Giselle", "https://images.pexels.com/photos/2345293/pexels-photo-2345293.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Shabaz", "Shabaz@gmail.com", "Shabaz", "https://images.pexels.com/photos/2080736/pexels-photo-2080736.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Bobbi", "Bobbi@gmail.com", "Bobbi", "https://images.pexels.com/photos/2680601/pexels-photo-2680601.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Leona", "Leona@gmail.com", "Leona", "https://images.pexels.com/photos/384553/pexels-photo-384553.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Jose", "Jose@gmail.com", "Jose", "https://images.pexels.com/photos/2950648/pexels-photo-2950648.jpeg?auto=compress&cs=tinysrgb&h=130"))
        tiktokSystem.addUser(DraftUser("Izabelle", "Izabelle@gmail.com", "Izabelle", "https://images.pexels.com/photos/3894557/pexels-photo-3894557.jpeg?auto=compress&cs=tinysrgb&h=130"))
    }

    private fun createPost(tiktokSystem: TiktokSystem, userId: String, titleIndex: Int, descriptionIndex: Int, videoIndex: Int) {
        tiktokSystem.addPost(userId, DraftPost(titles[titleIndex], descriptions[descriptionIndex], videos[videoIndex]))
    }

    private fun addPosts(tiktokSystem: TiktokSystem) {
        tiktokSystem.users.forEach {
            for (i in 0 .. random.nextInt(10, 40)) {
                createPost(tiktokSystem, it.id, random.nextInt(0, 399), random.nextInt(0, 399), random.nextInt(0, 399))
            }
        }
    }

    private fun createComment(tiktokSystem: TiktokSystem, userId: String, postId: String, commentIndex: Int) {
        tiktokSystem.addComment(userId, postId, DraftComment(comments[commentIndex]))
    }

    private fun addComments(tiktokSystem: TiktokSystem) {
        tiktokSystem.users.forEach {
            for (i in 0 .. random.nextInt(30, 100)) {
                createComment(tiktokSystem, it.id, tiktokSystem.posts[random.nextInt(0, tiktokSystem.posts.size - 1)].id, random.nextInt(0, 99))
            }
        }
    }

    private fun addLikes(tiktokSystem: TiktokSystem) {
        tiktokSystem.users.forEach {
            for (i in 0 .. random.nextInt(30, 1000)) {
                tiktokSystem.updateLike(it.id, tiktokSystem.posts[random.nextInt(0, tiktokSystem.posts.size - 1)].id)
            }
        }
    }

    private fun addFollowers(tiktokSystem: TiktokSystem) {
        tiktokSystem.users.forEach {
            for (i in 0 .. random.nextInt(5, 15)) {
                val userToFollow = tiktokSystem.users[random.nextInt(0, tiktokSystem.users.size - 1)]
                if (userToFollow.id != it.id) tiktokSystem.updateFollow(it.id, userToFollow.id)
            }
        }
    }

    fun getSystem(): TiktokSystem {
        val tiktokSystem = TiktokSystem()
        addUsers(tiktokSystem)
        addPosts(tiktokSystem)
        addComments(tiktokSystem)
        addLikes(tiktokSystem)
        addFollowers(tiktokSystem)
        return  tiktokSystem
    }

}
