package higherOrderFunction

fun main() {
    val sum: Calcable = Sum()
    val minus: Calcable = Minus()
    val product: Calcable = Product()
    val twiceSum = TwiceSum()

    println(sum.calc(5, 2))
    println(minus.calc(5, 2))
    println(product.calc(5, 2))
    println(twiceSum.calc(5, 2))
}

interface Calcable {
    fun calc(x: Int, y: Int): Int
}

class Sum : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return x + y
    }
}

class Minus : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return x - y
    }
}

class Product : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return x * y
    }
}

class TwiceSum : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return (x + y) * 2
    }
}