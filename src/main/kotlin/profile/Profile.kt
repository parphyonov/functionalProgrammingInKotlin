package profile

fun main() {
    showEmail(1132)
}

fun filterCollection() {
    ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.age < 30 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender == Gender.MALE }
        .toSet()
        .map { it.copy(age = it.age + 1) }
        .sortedByDescending { it.age }
        .forEach { println(it) }
}

fun showEmail(id: Int) {
    ProfilesRepository.profiles
        .find { it.id == id }
        ?.let {
            println(it.email)
        }
        ?: println("No matching profile")
}