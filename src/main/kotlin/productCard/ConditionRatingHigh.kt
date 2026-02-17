package productCard

class ConditionRatingHigh: Condition {
    override fun isSuitable(card: ProductCard): Boolean = card.productRating > 4.5
}