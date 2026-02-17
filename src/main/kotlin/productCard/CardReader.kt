package productCard

fun main() {
    val cards = CardsRepository.cards

    var filtered = filter(cards) { it.productPrice > 500 }
    filtered = filter(filtered) { it.productCategory == CardCategory.SPORTS }
    filtered = filter(filtered) { it.productRating > 4.0 }

    println("Total: ${cards.size} items")
    println("Filtered: ${filtered.size} items")
}

fun filter(cardSet: List<ProductCard>, isSuitable: (ProductCard) -> Boolean): List<ProductCard> {
    val result = mutableListOf<ProductCard>()

    for (card in cardSet) {
        if (isSuitable(card)) {
            result.add(card)
        }
    }

    return result.toList()
}