package profile

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.age < 30 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender == Gender.MALE }
        .transform { it.copy(age = it.age + 1) }

    for (profile in profiles)
        println("$profile")
}

fun <R> List<Person>.transform(transformation: (Person) -> R): List<R> {
    val result = mutableListOf<R>()
    for (person in this) {
        result.add(transformation(person))
    }
    return result.toList()
}

fun List<Person>.filter(isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()

    for (person in this) {
        if (isSuitable(person)) {
            result.add(person)
        }
    }

    return result.toList()
}