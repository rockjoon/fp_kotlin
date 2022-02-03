package higherOrderFunction

class PartialFunction<P, R>(
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
): (P) -> R {

    override fun invoke(p: P): R {
        if (condition(p)) {
            return f(p)
        } else {
            throw IllegalArgumentException("$p is not supported")
        }
    }

    fun isDefinedAt(p: P): Boolean = condition(p)

    fun invokeOrElse(p: P, default: R): R = if (condition(p)) f(p) else default

    fun orElse(that: PartialFunction<P, R>): PartialFunction<P, R> {
        return PartialFunction({p: P -> this.isDefinedAt(p)}, {
                p: P -> when {
                this.isDefinedAt(p) -> this(p)
                that.isDefinedAt(p) -> that(p)
                else -> throw IllegalArgumentException()
            }
        })
    }
}

fun <P, R> ((P) -> R).toPartialFunction(definedAt: (p: P) -> Boolean)
        : PartialFunction<P, R> = PartialFunction(definedAt, this)

fun <P1, P2, R> ((P1, P2) -> R).partial1(p1: P1): (P2) -> R {
    return { p2 ->  this(p1, p2)}
}

fun <P1, P2, R> ((P1, P2) -> R).partial2(p2: P2): (P1) -> R {
    return { p1 -> this(p1, p2)}
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial3(p1: P1): (P2, P3) -> R {
    return { p2, p3 -> this(p1, p2, p3) }
}

fun main() {
    val condition : (Int) -> Boolean = {p: Int -> p % 2 == 0}
    val body: (Int) -> String = {p: Int -> "$p is even"}
    val isEven: PartialFunction<Int, String> = PartialFunction(condition, body)
    val isOdd = ({p:Int -> "$p is odd"}).toPartialFunction { !condition(it) }
    println(isEven(100))
    println(isOdd(99))

    val func = { a: String, b: String -> a + b }
    val partiallyAppliedFunc1 = func.partial1("Hello")
    val result1 = partiallyAppliedFunc1("world")
    println(result1)

    val partiallyAppliedFunc2 = func.partial2("World")
    val result2 = partiallyAppliedFunc2("Hello ")
    println(result2)

    val func2 = { a: String, b: String, c: String -> a + b + c }
    val partiallyAppliedFunc3 = func2.partial3("A")
    val result3 = partiallyAppliedFunc3("B", "C")
    println(result3)


}