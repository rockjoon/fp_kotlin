package higherOrderFunction

fun main() {
    val partial1 = multiThree(1)
    val partial2 = partial1(2)
    val partial3 = partial2(3)
    println(partial3)
    println(multiThree(1)(2)(3))

    val max1 = max(1)
    val max2 = max1(10)
    println(max2)
    println(max(15)(7))

    val plusFunc = { a: Int, b: Int, c: Int -> a + b + c}
    val plusCurried = plusFunc.curried()
    val plus1 = plusCurried(1)
    val plus2 = plus1(2)
    val plus3 = plus2(3)
    println(plus3)
    println(plusCurried(1)(2)(3))

    val plusUncurried = plusCurried.uncurried()
    println(plusUncurried(1, 2, 3))

    val minFunc = { a: Int, b: Int -> if (a > b) b else a }
    val minFuncCurried = minFunc.curried()
    val min1 = minFuncCurried(1)
    val min2 = min1(10)
    println(min2)
    println(minFuncCurried(1)(10))
    val minFuncUncurried = minFuncCurried.uncurried()
    println(minFuncUncurried(9, 10))

}

private fun multiThree(a: Int) = { b: Int -> { c: Int -> a * b * c }}

private fun max(a: Int) = { b: Int -> if (a > b) a else b}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R = {
    p1: P1 ->  { p2: P2 -> { p3: P3 -> this(p1, p2, p3)}}
}

fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurried(): (P1, P2, P3) -> R = {
    p1: P1, p2: P2, p3: P3 ->  this(p1)(p2)(p3)
}

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = {
    p1: P1 -> { p2: P2 ->  this(p1, p2) }
}

fun <P1, P2, R> ((P1) -> (P2) -> R).uncurried(): (P1, P2) -> R = {
    p1: P1, p2: P2 -> this(p1)(p2)
}