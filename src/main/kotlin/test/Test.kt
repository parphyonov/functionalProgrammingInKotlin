package test

import java.io.File

//val numbers = mutableListOf<Int>()

fun main() {
    val file = File("test.txt")
    val b = file.readText().trim().toInt()

    println(sum(5, b))
}

//fun sum(a: Int, b: Int): Int {
//    val res = a + b
//
//    numbers.add(res)
//    return res
//}

fun sum(a: Int, b: Int): Int = a + b