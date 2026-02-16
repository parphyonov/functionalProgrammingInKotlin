package profile

import kotlinx.serialization.json.Json
import java.io.File

object ProfilesRepository {
    private val file = File("profiles.json")

    private val _profiles = loadProfiles()
    val profiles
        get() = _profiles.toList()

    private fun loadProfiles(): MutableList<Person> {
        val content = this.file.readText().trim()
        return Json.decodeFromString<MutableList<Person>>(content)
    }
}