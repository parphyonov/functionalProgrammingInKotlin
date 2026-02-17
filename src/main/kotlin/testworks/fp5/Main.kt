package testworks.fp5

fun main() {
    startProcessing()
}

fun processNumbers(
    numList: List<Int>,
    predicate: (Int) -> Boolean,
    transform: (Int) -> Int
): List<Int> {
    return numList
        .filter(predicate)
        .map(transform)
}

fun startProcessing() {
    println("Введите числа, разделенные пробелами:")
    val rawNumbers = readln().split(" ")
    val numList = rawNumbers.map { it.toInt() }

    val predicate: (Int) -> Boolean = { it > 10 }
    val transform: (Int) -> Int = { it * 3 }

    val processed = processNumbers(numList, predicate, transform)

    print("Результат обработки: $processed")
}