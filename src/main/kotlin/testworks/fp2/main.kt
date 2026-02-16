package testworks.fp2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val file = File("products.txt")
    val content = file.readText().trim()
    val cards = loadProducts(content)
    for (card in cards) {
        println(card.productCategory)
    }
}

@Serializable
enum class ProductCategory {
    @SerialName("Electronics")
    ELECTRONICS,

    @SerialName("Sports")
    SPORTS,

    @SerialName("Beauty")
    BEAUTY,

    @SerialName("Clothing")
    CLOTHING,

    @SerialName("Home Goods")
    HOME_GOODS
}

@Serializable
data class Product(
    @SerialName("id") val id: Int,
    @SerialName("product_name") val productName: String,
    @SerialName("product_description") val productDescription: String,
    @SerialName("product_category") val productCategory: ProductCategory,
    @SerialName("product_price") val productPrice: Double,
    @SerialName("product_brand") val productBrand: String,
    @SerialName("product_rating") val productRating: Double,
    @SerialName("product_availability") val productAvailability: Boolean
)

fun loadProducts(jsonContent: String): List<Product> {
    return Json.decodeFromString<List<Product>>(jsonContent)
}

