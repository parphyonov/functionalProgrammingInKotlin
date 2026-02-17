package productCard

import testworks.fp2.Product

interface Condition {
    fun isSuitable(card: ProductCard): Boolean
}