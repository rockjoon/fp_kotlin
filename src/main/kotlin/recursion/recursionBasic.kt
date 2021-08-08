package recursion

fun main() {
    println(sum(10))
    println(power(2, 10))
    println(factorial(5))
    println(max(listOf(4, 8, 1, 5, 6)))
}

private fun sum(n: Int): Int = when {
    n < 0 -> 0
    else -> n + sum(n-1)
}

private fun power(x:Int, n: Int) : Int = when {
    n < 1 -> 1
    else -> x * power(x, n - 1)
}

private fun factorial(n: Int): Int {
    return when {
        n < 1 -> 1
        else -> n * factorial(n - 1)
    }
}

fun List<Int>.head() = first()
fun List<Int>.tail() = drop(1)

private fun max(list: List<Int>) : Int {
    return when {
        list.isEmpty() -> throw IllegalArgumentException()
        list.size == 1 -> list[0]
        else -> {
            val head = list.head()
            val tail = max(list.tail())
            return if (head > tail) head else tail
        }
    }
}