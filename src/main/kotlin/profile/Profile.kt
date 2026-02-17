package profile

fun main() {
    val profiles = ProfilesRepository.profiles

    var filtered = filter(profiles) { it.age > 25 }
    filtered = filter(filtered) { it.age < 30 }
    filtered = filter(filtered) { it.firstName.startsWith("A") }
    filtered = filter(filtered) { it.gender == Gender.MALE }

    val fullNames = transform(filtered) { "${it.firstName} ${it.lastName}"}

    val selectedCustomers =
        transform(filtered) { it.copy(age = it.age + 1) }

    for (customer in selectedCustomers)
        println("$customer")
}

fun <R> transform(profiles: List<Person>, transformation: (Person) -> R): List<R> {
    val result = mutableListOf<R>()
    for (person in profiles) {
        result.add(transformation(person))
    }
    return result
}

fun filter(profiles: List<Person>, isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()

    for (person in profiles) {
        if (isSuitable(person)) {
            result.add(person)
        }
    }

    return result.toList()
}