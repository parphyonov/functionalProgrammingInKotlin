package productCard

fun main() {
    val cards = CardsRepository.cards
    var filtered = filter(cards, ConditionPriceAbove500())
    filtered = filter(filtered, ConditionCategorySport())

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