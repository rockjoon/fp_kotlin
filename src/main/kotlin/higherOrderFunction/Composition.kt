package higherOrderFunction

fun main() {
    println(composedAddTwice(4))
    val addThree = { i: Int -> i + 3 }
    val twice = { i: Int -> i * 2 }
    val composed = addThree compose twice
    println(composed(4))

    val powerOfTwo = { x: Int -> power(x.toDouble(), 2).toInt() }
    val gcdPowerOfTwo = { a: Int, b: Int -> gcd(powerOfTwo(a), powerOfTwo(b)) }

    require(minComposePower(listOf(3, 4)) == 9)
    require(gcdPowerOfTwo(2, 4) == 4)

    val curriedGcd = ::gcd.curried()
    val curriedGcdPower = curriedGcd compose powerOfTwo
    println(curriedGcdPower(25)(5))

    val curriedGcd2 = { m: Int, n: Int -> gcd(m, powerOfTwo(n))}.curried()
    val composedGcdPower = curriedGcd2 compose powerOfTwo
    println(composedGcdPower(25)(5))
}

private fun addThree(i: Int) = i + 3

private fun twice(i: Int) = i * 2

private fun composedAddTwice(i: Int) = addThree(twice(i))

infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R = { gInput: G ->
    this(g(gInput))
}

private tailrec fun min(list: List<Int>, acc: Int = Int.MAX_VALUE): Int = when {
    list.isEmpty() -> acc
    else -> {
        val min = if (acc < list.first()) acc else list.first()
        min(list.drop(1), min)
    }
}

val minF: (List<Int>) -> Int = { list -> min(list) }
val powerF: (Int) -> Int = { it * it }

fun minComposePower(list: List<Int>): Int = (powerF compose minF)(list)

private tailrec fun gcd(m: Int, n: Int): Int = when (n) {
    0 -> m
    else -> gcd(n, m % n)
}

private tailrec fun power(x: Double, n: Int, acc: Double = 1.0): Double = when(n) {
    0 -> acc
    else -> power(x, n - 1, acc * x)
}


