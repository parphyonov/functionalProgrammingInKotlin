package profile

fun main() {
    val profiles = ProfilesRepository.profiles

    var filtered = filter(profiles) { it.age > 25 }
    filtered = filter(filtered) { it.age < 30 }
    filtered = filter(filtered) { it.firstName.startsWith("A") }
    filtered = filter(filtered) { it.gender == Gender.MALE }

    for (person in filtered) {
        println(person)
    }

    println("Total ${profiles.size}")
    println("Filtered: ${filtered.size}")
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