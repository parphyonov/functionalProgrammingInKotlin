package productCard

fun main() {
    CardsRepository.cards
        .filter { it.productCategory == CardCategory.CLOTHING }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .map { "${it.productId} - ${it.productName} - ${it.productPrice}" }
        .forEach { println(it) }
}