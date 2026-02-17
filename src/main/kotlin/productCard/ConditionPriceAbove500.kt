package productCard

class ConditionPriceAbove500: Condition {
    override fun isSuitable(card: ProductCard): Boolean = card.productPrice > 500
}