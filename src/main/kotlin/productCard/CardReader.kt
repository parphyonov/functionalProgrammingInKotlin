package productCard

fun main() {
    CardsRepository.cards
        .also { println("Filtering by product category") }
        .filter { it.productCategory == CardCategory.CLOTHING }
        .also { println("Increasing the price x2") }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .also { println("Strings formation") }
        .map { "${it.productId} - ${it.productName} - ${it.productPrice}" }
        .also { println("Printing the outcome") }
        .forEach { println(it) }
}