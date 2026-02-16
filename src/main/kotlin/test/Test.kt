package test

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val bookShelf = listOf(
        Book("Ivan Pavlov in Leningrad", "Various", 1986),
        Book("The Word is God", "Lyutsiya Drozdova-Shichko", 1995),
        Book("The Left Hand of Darkness", "Urlula K. LeGuin", 1964),
        Book("Fiasco", "Stanislaw Lem", 1971),
        Book("A Century Too Little for Men", "Fyodor Uglov", 1988),
        Book("Memorandum to Humanity", "Aleksandr Shichko", 1993),
        Book("A Beetle on the Anthill", "Arkady and Boris Strugatzkys", 1964),
        Book("Time Wanderers", "Arkady and Boris Strugatzkys", 1966),
        Book("One Billion Years Before the End of the World", "Arkady and Boris Strugazkys", 1971),
        Book("Fuckup", "Konstantin Krylov", 2009)
    )

    val bookFile = File("books.json")
    bookFile.writeText(Json.encodeToString(bookShelf))

    val reopenedShelf = Json.decodeFromString<List<Book>>(bookFile.readText())

    for (book in reopenedShelf)
        println(book)
}