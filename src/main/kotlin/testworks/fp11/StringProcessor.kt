package testworks.fp11

fun processStrings(strings: List<String>): List<String> {
    return strings
        .also { println("Исходный список: $it") }
        .filter { it.isNotBlank() }
        .also { println("Этап 1: Осталось ${it.size} непустых строк") }
        .map { it.trim() }
        .filter { it.length > 3 }
        .also { println("Этап 2: Строки длиной более 3 символов: $it") }
        .sortedBy { it.length }
        .also { println("Этап 3: Первые 3 строки после сортировки: ${it.take(3)}") }
        .map { it.uppercase() }
        .also { println("Этап 4: Все строки в верхнем регистре: $it") }
        .distinct()
        .take(5)
        .also { println("Этап 5: Итоговый результат: $it") }
}

fun main() {
    processStrings(listOf("   hello", "  world ", " test", "hello    "))
}