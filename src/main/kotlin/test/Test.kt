package test

var age: Int? = null

fun main() {
    val result = age?.let {
        if (it >= 18) {
            "Adult"
        } else {
            val diff = 18 - it
            "$diff before adult"
        }
    }

    result?.let { println(it) }
}