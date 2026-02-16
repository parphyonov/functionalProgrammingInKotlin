package productCard

import kotlinx.serialization.json.Json
import java.io.File

object CardsRepository {
    private val file = File("cards.json")

    private val _cards = loadCards()
    val cards
        get() = _cards.toList()

    private fun loadCards(): MutableList<ProductCard> {
        val content = file.readText()
        return Json.decodeFromString<MutableList<ProductCard>>(content)
    }
}