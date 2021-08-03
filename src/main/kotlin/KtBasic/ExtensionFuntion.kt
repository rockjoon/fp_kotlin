package KtBasic

fun Int.product(value: Int): Int {
    return this * value
}

fun String.hello(): String {
    return "hello $this"
}

fun String.printHello() {
    println("hello $this")
}

fun main() {
    println(10.product(2))
    println("world".hello())
    "world".printHello()
}