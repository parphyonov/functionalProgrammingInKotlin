package testworks.fp6

fun <T, R> transform(list: List<T>, transformation: (T) -> R): List<R> {
    return list.map { transformation(it) }
}