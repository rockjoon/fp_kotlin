package higherOrderFunction

private fun <P1, P2, R> ((P1, P2) -> R).partiallyApplied(p1: P1): (P2) -> R {
    return { p2: P2 -> this(p1, p2) }
}

private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partiallyApplied2(p1: P1): (P2, P3) -> R {
    return { p2: P2, p3: P3 -> this(p1, p2, p3) }
}

private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partiallyApplied3(p1: P1, p2: P2): (P3) -> R {
    return { p3: P3 -> this(p1, p2, p3) }
}

private fun multiThree(a: Int, b: Int, c: Int) = a * b * c

private fun multiThreeChain(a: Int) = { b: Int -> { c: Int -> a * b * c } }

private fun maxCurried(a: Int) = { b: Int -> if (a > b) a else b }

private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).cur(): (P1) -> (P2) -> (P3) -> R {
    return { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }
}

private fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncur() : (P1, P2, P3) -> R {
    return {p1: P1, p2: P2, p3: P3 -> this(p1)(p2)(p3) }
}

fun main() {
    val partially = { a: Int, b: Int -> a - b }
    val applied = partially.partiallyApplied(10)(5)
    println(applied)
    val max = maxCurried(10)(20)
    println(max)
}
