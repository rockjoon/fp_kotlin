package higherOrderFunction

import kotlin.math.max

fun main() {
    val list1 = listOf(6, 3, 2, 1, 4)
    val list2 = listOf(7, 4, 2, 6, 3)

    val add = { p1: Int, p2: Int -> p1 + p2 }
    val result1 = zipWith(add, list1, list2)
    println(result1)

    val max = { p1: Int, p2: Int -> max(p1, p2) }
    val result2 = zipWith(max, list1, list2)
    println(result2)

    val strcat = { p1: String, p2: String -> p1 + p2 }
    val result3 = zipWith(strcat, listOf("a", "b"), listOf("c", "d"))
    println(result3)

    val product = { p1: Int, p2: Int -> p1 * p2 }
    val result4 = zipWith(product, list1, list2)
    println(result4)

    val isEven = { x: Int -> x % 2 == 0 }
    val result5 = takeWhile(isEven, list1)
    println(result5)

}

private tailrec fun <P1, P2, R> zipWith(
    func: (P1, P2) -> R, list1: List<P1>, list2: List<P2>,
    acc: List<R> = listOf()
): List<R> = when {
    list1.isEmpty() || list2.isEmpty() -> acc
    else -> {
        val zipList = acc + listOf(func(list1.first(), list2.first()))
        zipWith(func, list1.drop(1), list2.drop(1), zipList)
    }
}

private tailrec fun <P> takeWhile(
    predicate: (P) -> Boolean, list: List<P>, acc: List<P> = listOf()
): List<P> = when {
    list.isEmpty() || !predicate(list.first()) -> acc
    else -> takeWhile(predicate, list.drop(1), acc + list.first())
}