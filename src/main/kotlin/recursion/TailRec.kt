package recursion

fun main() {
    println(power(2, 10))
    println(powerTail(2, 10))
    println(maximum(listOf(1, 3, 2, 8, 5)))
    println(maximumTail(listOf(1, 3, 8, 5, 9)))
    println(reverse("abcd"))
    println(reverseTail("abcd"))
    println(toBinary(4))
    println(toBinaryTail(16))
    println(replicate(4, 6))
    println(replicateTail(3, 6))
    println(take(4, listOf(1, 9, 3, 4, 5)))
    println(takeTail(3, listOf(1, 9, 3, 4, 5)))
}

private fun power(n: Int, x: Int): Int = when (x) {
    0 -> 1
    else -> n * power(n, x - 1)
}

private tailrec fun powerTail(n: Int, x: Int, acc: Int = 1): Int = when (x) {
    0 -> acc
    else -> powerTail(n, x - 1, n * acc )
}

private fun maximum(list: List<Int>): Int = when{
    list.size == 1 -> list.first()
    else -> {
        val head = list.first()
        val maxVal = maximum(list.tail())
        if (head > maxVal) head else maxVal
    }
}

private tailrec fun maximumTail(list: List<Int>, acc: Int = Int.MIN_VALUE): Int {
    return when {
        list.isEmpty() -> acc
        else -> {
            val head = list.first()
            val tail = list.drop(1)
            val maxVal = if (head > acc) head else acc
            maximumTail(tail, maxVal)
        }
    }
}

private fun reverse(str: String): String = when(str) {
    "" -> ""
    else -> reverse(str.drop(1)) + str.first()
}

private tailrec fun reverseTail(str: String, acc: String = ""): String = when (str) {
    "" -> acc
    else -> reverseTail(str.drop(1), str.first() + acc)
}

private fun toBinary(no: Int): String = when (no) {
    0 -> "0"
    1 -> "1"
    else -> toBinary(no / 2) + no % 2
}

private tailrec fun toBinaryTail(no: Int, acc: String = ""): String = when (no) {
    0 -> acc
    1 -> "1$acc"
    else -> {
        val binary = "${no % 2}$acc"
        toBinaryTail(no / 2, binary)
    }
}

private fun replicate(size: Int, n: Int): List<Int> = when (size) {
    0 -> listOf()
    else -> listOf(n) + replicate(size - 1, n)
}

private fun replicateTail(size: Int, n: Int, acc: List<Int> = listOf()): List<Int> = when(size) {
    0 -> acc
    else -> replicateTail(size - 1, n, listOf(n) + acc)
}

private fun take(n: Int, list: List<Int>): List<Int> = when {
    n <= 0 -> listOf()
    list.isEmpty() -> listOf()
    else -> listOf(list[0]) + take(n - 1, list.tail())
}

private tailrec fun takeTail(n: Int, list: List<Int>, acc: List<Int> = listOf()): List<Int> = when {
    n <= 0 -> acc
    list.isEmpty() -> acc
    else -> {
        val taken = acc + list.first()
        takeTail(n - 1, list.tail(), taken)
    }
}
