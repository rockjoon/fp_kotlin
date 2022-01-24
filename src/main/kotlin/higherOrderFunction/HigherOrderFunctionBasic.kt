package higherOrderFunction

fun main() {
    val ints: List<Int> = listOf(3, 5, 7, 9, 10)
    println(twiceBiggerThanTen(ints))
    println(twiceBiggerThanTenFP(ints))
    println(twiceBiggerThanTenFP2(ints))
}
private fun higherOrderFunction1(function: () -> Unit): Unit {
    function
}

private fun higherOrderFunction2(): () -> Unit {
    return { println("hof2")}
}

private fun twiceBiggerThanTen(list: List<Int>): List<Int> {
    val resultList = mutableListOf<Int>()
    for (i in list) {
        val twice = i * 2
        if ( twice > 10) resultList.add(twice)
    }
    return resultList
}

private fun twiceBiggerThanTenFP(list: List<Int>): List<Int> {
    return list.map { e -> e * 2 }
        .filter { e -> e > 10 }
}

private fun twiceBiggerThanTenFP2(list: List<Int>): List<Int> {
    return list.map { it * 2 }
        .filter { it > 10 }
}

private fun twice(x: Int): Int = x * 2

private fun partialTwice(x: Int): Int =
    if (x < 100) {
        x * 2
    } else {
        throw IllegalArgumentException()
    }

private fun sayNumber1(x: Int): String = when (x) {
    1 -> "one"
    2 -> "two"
    3 -> "three"
    else -> "not in range"
}

private fun sayNumber2(x: Int): String = when (x) {
    1 -> "one"
    2 -> "two"
    3 -> "three"
    else -> throw IllegalArgumentException()
}
