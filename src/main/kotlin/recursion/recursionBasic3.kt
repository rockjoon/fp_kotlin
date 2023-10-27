package recursion

fun main() {
//    println(aMaximum(listOf(1, 4, 3, 6, 8)))
//    println(aReverse("abcd"))
//    println(aToBinary(8))
//    println(aReplicate(2, 5))
//    println(aTake(3, listOf(1, 2, 3, 4, 5)))
//    println(aContains(10, listOf(1, 2, 3, 4, 5, 10)))

}

private fun aMaximum(list: List<Int>): Int {
    return when {
        list.isEmpty() -> error("no list")
        list.size == 1 -> list.first()
        else -> {
            val head = list.first()
            val maximum = aMaximum(list.tail())
            if (head > maximum) head else maximum
        }
    }
}

private fun aReverse(strings: String): String = when {
    strings.isEmpty() -> ""
    else -> aReverse(strings.tail()) + strings.head()
}

private fun aToBinary(no: Int): String = when {
    no < 0 -> error("positive only")
    no < 2 -> no.toString()
    else -> {
        val v = no / 2
        val mod = (no % 2)
        aToBinary(v) + mod
    }
}

private fun aReplicate(n: Int, element: Int): List<Int> = when {
    n <= 0 -> emptyList()
    else -> aReplicate(n - 1, element).plus(element)
}

private fun aTake(n: Int, list: List<Int>): List<Int> = when {
    n <= 0 -> emptyList()
    list.isEmpty() -> emptyList()
    else -> listOf(list.head()) + aTake(n - 1, list.tail())
}

private fun aContains(n: Int, list: List<Int>): Boolean = when {
    list.isEmpty() -> false
    list.head() == n -> true
    else -> aContains(n, list.tail())
}

private fun aFibo(n: Int): Int = when(n) {
    0 -> 0
    1 -> 1
    else -> aFibo(n - 2) + aFibo(n - 1)
}

private tailrec fun rFibo(n: Int, first: Int = 0, second: Int = 1): Int = when(n) {
    0 -> first
    1 -> second
    else -> rFibo(n-1, second, first + second)
}
