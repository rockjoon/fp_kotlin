fun main() {
    val f = { a: Int, b: Int -> a + b }
    val list1 = listOf(1, 3, 5, 7, 9)
    val list2 = listOf(1, 3, 5, 7)
    val result = zipWith(f, list1, list2)
    val f2 = { a: Int -> a > 5 }
    println(result)
    println(takeWhile(f2, list1))
}

private tailrec fun <P, R> zipWith(
    f: (P, P) -> R, list1: List<P>, list2: List<P>,
    acc: List<R> = listOf()
): List<R> = when {
    list1.isEmpty() || list2.isEmpty() -> acc
    else -> {
        val zipList = acc + f(list1.first(), list2.first())
        zipWith(f, list1.drop(1), list2.drop(1), zipList)
    }
}

private tailrec fun <P> takeWhile(f: (P) -> Boolean, list:List<P>,
                                  acc:List<P> = listOf()): List<P> = when {
    list.isEmpty() -> acc
    else -> {
        val filtered = if (f(list.first())) acc + list.first() else acc
        takeWhile(f, list.drop(1), filtered)
    }
}