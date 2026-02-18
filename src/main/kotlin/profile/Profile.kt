package profile

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.age < 30 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender == Gender.MALE }
        .toSet()
        .map { it.copy(age = it.age + 1) }
        .map { it.firstName }

    for (profile in profiles)
        println(profile)
}