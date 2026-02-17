package testworks.fp7

fun main() {
    processList()
}

fun List<Int>.sumOfEvens(): Int = this.filter { it % 2 == 0 }.sum()

fun processList() {
    val sum = readln()
        .split(" ")
        .map { it.toInt() }
        .sumOfEvens()

    println("Сумма чётных чисел: $sum")
}