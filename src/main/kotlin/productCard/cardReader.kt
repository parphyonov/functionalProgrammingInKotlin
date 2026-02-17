package productCard

fun main() {
    val cards = CardsRepository.cards

    var filtered = filter(cards, object : Condition {
        override fun isSuitable(card: ProductCard): Boolean =
            card.productPrice > 500
    })

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(card: ProductCard): Boolean =
            card.productCategory == CardCategory.SPORTS
    })

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(card: ProductCard): Boolean =
            card.productRating > 4.0
    })

    println("Total: ${cards.size} items")
    println("Filtered: ${filtered.size} items")

//    for (card in filtered) {
//        println(card)
//    }
}

fun filter(cardSet: List<ProductCard>, condition: Condition): List<ProductCard> {
    val result = mutableListOf<ProductCard>()

    for (card in cardSet) {
        if (condition.isSuitable(card)) {
            result.add(card)
        }
    }

    return result.toList()
}