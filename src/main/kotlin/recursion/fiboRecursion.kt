package recursion

fun main() {
    println(fiboRecursion(150))
}

private fun fiboRecursion(n: Int): Int {
    println(n)
    return when (n) {
        0 -> 0
        1 -> 1
        else -> fiboRecursion(n - 1) + fiboRecursion(n - 2)
    }
}