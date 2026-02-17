package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    var filtered = filter(profiles, ConditionOlderThan25)

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(person: Person): Boolean =
            person.firstName.startsWith("A")
    })

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(person: Person): Boolean =
            person.gender == Gender.MALE
    })

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(person: Person): Boolean =
            person.age < 30
    })

    for (person in filtered) {
        println(person)
    }

    println("Total ${profiles.size}")
    println("Filtered: ${filtered.size}")
}

fun filter(profiles: List<Person>, condition: Condition): List<Person> {
    val result = mutableListOf<Person>()

    for (person in profiles) {
        if (condition.isSuitable(person)) {
            result.add(person)
        }
    }

    return result
}