package productCard

fun main() {
    val cards = CardsRepository.cards
        .filter { it.productCategory == CardCategory.CLOTHING }
        .transform { it.copy(productPrice = it.productPrice * 2) }
        .transform { "${it.productId} - ${it.productName} - ${it.productPrice}" }

    for (card in cards) {
        println(card)
    }
}

fun <T> List<ProductCard>.transform(transformation: (ProductCard) -> T): List<T> {
    val result = mutableListOf<T>()

    for (card in this) {
        result.add(transformation(card))
    }

    return result.toList()
}

fun List<ProductCard>.filter(isSuitable: (ProductCard) -> Boolean): List<ProductCard> {
    val result = mutableListOf<ProductCard>()

    for (card in this) {
        if (isSuitable(card)) {
            result.add(card)
        }
    }

    return result.toList()
}