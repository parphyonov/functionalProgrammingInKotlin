package productCard

fun main() {
    val cards = CardsRepository.cards

    val clothesOnly =
        filter(cards) { it.productCategory == CardCategory.CLOTHING }

    val x2clothes =
        transform(clothesOnly) { it.copy(productPrice = it.productPrice * 2) }
    val titleStrings =
        transform(x2clothes)
        { "${it.productId} - ${it.productName} - ${it.productPrice}"}

    for (title in titleStrings) {
        println(title)
    }

    println("Total: ${cards.size} items")
    println("Result: ${x2clothes.size} items")
}

fun <T> transform(cardSet: List<ProductCard>, transformation: (ProductCard) -> T): List<T> {
    return cardSet
        .map { transformation(it) }
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