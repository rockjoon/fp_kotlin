fun fiboRecursion(n: Int): Int {
    println("fibo" + n)
    return when (n) {
        0 -> 0
        1 -> 1
        else -> fiboRecursion(n - 1) + fiboRecursion(n - 2)
    }
}

fun main(args: Array<String>) {
    println(fiboRecursion(5))
}