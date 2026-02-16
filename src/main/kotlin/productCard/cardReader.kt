package productCard

fun main() {
    val cards = CardsRepository.cards

    for (card in cards) {
        println(card)
    }
}