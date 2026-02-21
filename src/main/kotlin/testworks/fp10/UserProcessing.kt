package testworks.fp10

data class User(val name: String, val email: String?)

fun sendEmail(email: String) {
    println("Сообщение отправлено на $email")
}

fun processUserEmail(user: User) {
    user.email?.let {
        sendEmail(it)
    }
}

fun main() {
    processUserEmail(User(
        "Krechmar Gohmand",
        null
    ))
}