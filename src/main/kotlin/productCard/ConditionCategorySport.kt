package productCard

import testworks.fp2.ProductCategory

class ConditionCategorySport: Condition {
    override fun isSuitable(card: ProductCard): Boolean = card.productCategory == CardCategory.SPORTS
}