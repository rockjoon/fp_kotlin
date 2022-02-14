package higherOrderFunction

import java.lang.Math.abs

fun main() {
    val absolute = { i: List<Int> -> i.map { abs(it) }}
    val negative = { i: List<Int> -> i.map { -it }}
    val minimum = { i: List<Int> -> i.minOrNull() }

    val result = minimum(negative(absolute(listOf(3, -1, 5, -2, -4, 8, 14))))
    println(result)

    val pfResult = minimum compose negative compose absolute
    println(pfResult(listOf(3, -1, 5, -2, -4, 8, 14)))

    val powerWithMax = power compose max
    println(powerWithMax(listOf(1, 3, 2, 7, 5)))
    println(powerWithMax2(listOf(1, 3, 2, 7, 5)))

    println(gcd(20, 25))
    println(power(4, 3))

    val powerOfTwo = { x: Int -> power(x, 2).toInt() }
    val gcdPowerOfTwo = { x1: Int, x2: Int -> gcd(powerOfTwo(x1), powerOfTwo(x2)) }
    println(gcdPowerOfTwo(25, 5))

    val curriedGcd1 = :: gcd.curried()
    val composedGcdPowerOfTwo1 = curriedGcd1 compose powerOfTwo
    println(composedGcdPowerOfTwo1(25)(5))

    val curriedGcd2 = { n: Int, m: Int -> gcd(n, powerOfTwo(m)) }.curried()
    val composedGcdPowerOfTwo2 = curriedGcd2 compose powerOfTwo
    println(composedGcdPowerOfTwo2(25)(5))

}

private val power: (Int) -> Int = { it * it }
private val max: (List<Int>) -> Int = { it.maxOrNull()!! }
private fun powerWithMax2(list: List<Int>): Int = (power compose max)(list)

private tailrec fun gcd(n: Int, m: Int): Int = when (m) {
    0 -> n
    else -> gcd(m, n % m)
}

private tailrec fun power(a: Int, b: Int, acc: Double = 1.0): Double = when(b) {
    0 -> acc
    else -> power(a, b - 1, a * acc)
}


