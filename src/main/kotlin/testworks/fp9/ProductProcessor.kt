package testworks.fp9

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String
)

fun processProductsForUI(products: List<Product>): List<String> {
    return products
        .filter { it.price >= 100 }
        .filter { it.category == "Electronics" || it.category == "Books" }
        .sortedBy { it.price }
        .map { "Product ID: ${it.id} | Name: ${it.name} | Price: $${it.price}" }
}

fun main() {
    val products = listOf(
        Product(1, "Laptop", 999.99, "Electronics"),
        Product(2, "Notebook", 12.99, "Books"),
        Product(3, "Tablet", 299.99, "Electronics"),
        Product(4, "Novel", 15.49, "Books"),
        Product(5, "Pen", 2.99, "Stationery")
    )

    processProductsForUI(products)
        .forEach { println(it) }
}