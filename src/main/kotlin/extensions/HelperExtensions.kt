package extensions

inline fun <T, R> Iterable<T>.transform(transform: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (person in this) {
        result.add(transform(person))
    }
    return result.toList()
}

inline fun <R> Iterable<R>.filter(predicate: (R) -> Boolean): List<R> {
    val result = mutableListOf<R>()

    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }

    return result.toList()
}