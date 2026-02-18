package productCard

fun main() {
    val cards = CardsRepository.cards
        .filter { it.productCategory == CardCategory.CLOTHING }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .map { "${it.productId} - ${it.productName} - ${it.productPrice}" }

    for (card in cards) {
        println(card)
    }
}