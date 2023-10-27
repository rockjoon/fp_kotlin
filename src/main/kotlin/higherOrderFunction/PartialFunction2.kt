package higherOrderFunction

class PartialFunction2<in P, out R>
    (
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
) : (P) -> R {
    override fun invoke(p: P): R = when {
        condition(p) -> f(p)
        else -> throw IllegalArgumentException("$p isn't supported")
    }

}

private fun <P, R> ((P) -> R).toPartialFunction2(condition: (P) -> Boolean) : PartialFunction<P, R>
= PartialFunction(condition, this)

fun main() {
    val condition : (Int) -> Boolean = {it < 100}
    val f : (Int) -> (Int) = { it * 2 }

    val result = f.toPartialFunction2(condition)(50)
    println(result)
}