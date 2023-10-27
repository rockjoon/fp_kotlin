package higherOrderFunction

private fun <P1, P2, R> ((P1, P2) -> R).part1(p1: P1) : (P2) -> R {
    return { p2: P2 ->  this(p1, p2) }
}

private fun<P1, P2, P3, R> ((P1, P2, P3) -> R).part2(p1: P1, p2: P2) : (P3) -> R {
   return {p3: P3 -> this(p1, p2, p3)}
}

fun main() {
    val base = { a: Int, b: Int -> a * b}
    val result = base.part1(10)(20)
    println(result)

    val base2 = {a: Int, b: Int, c: Int -> a + b + c}
    val result2 = base2.part2(1, 2)(3)
    val part = base2.part2(1, 2)
    val result3 = part(3)
    println(result3)
}

