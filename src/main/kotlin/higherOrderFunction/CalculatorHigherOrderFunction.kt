package higherOrderFunction

fun main() {
    val sum: (Int, Int) -> Int = {x, y -> x + y}
    val minus: (Int, Int) -> Int = {x, y -> x - y}
    val product: (Int, Int) -> Int = {x, y -> x * y}
    val twiceSum: (Int, Int) -> Int = {x, y -> (x + y) * 2}

    println(higherOrderFunction(sum, 5, 2))
    println(higherOrderFunction(minus, 5, 2))
    println(higherOrderFunction(product, 5, 2))
    println(higherOrderFunction(twiceSum, 5, 2))
}

private fun higherOrderFunction(func: (Int, Int) -> Int, x: Int, y: Int): Int {
    return func(x, y)
}