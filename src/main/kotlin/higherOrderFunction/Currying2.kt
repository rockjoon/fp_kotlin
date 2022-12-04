import higherOrderFunction.curried

private fun multiThree(a: Int, b: Int, c: Int): Int = a * b * c

private fun multiThree(a: Int) = { b: Int -> { c: Int -> a * b * c } }

private fun main() {
    val currying1 = multiThree(1)
    val currying2 = currying1(2)
    val currying3 = currying2(3)
    println(currying3)
    println(multiThree(1)(2)(3))
    println(multiThree(1, 2, 3))

    val max1 = max(1)
    val max2 = max1(5)
    println(max2)
    println(max(1)(10))

    val multiThreeCurried = {a:Int, b:Int, c:Int -> a * b * c}.curried()
    println(multiThreeCurried(1)(2)(4))
    val multiThreeUncurried = multiThreeCurried.uncurried()
    println(multiThreeUncurried(1, 2, 4))

    val minCurried = {a: Int, b: Int -> if (a < b) a else b }.curried()
    println(minCurried(5)(2))
}

private fun max(a: Int, b: Int): Int = if (a> b) a else b

private fun max(a: Int): (Int) -> Int {
    return { b: Int -> if (a > b) a else b }
}

private fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R {
    return { p1: P1 -> { p2: P2 -> {p3: P3 -> this(p1, p2, p3)}}}
}

private fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurried(): (P1, P2, P3) -> R {
    return {p1: P1, p2: P2, p3: P3 ->  this(p1)(p2)(p3) }
}








