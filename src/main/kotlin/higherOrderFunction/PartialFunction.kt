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

fun main() {
    val condition : (Int) -> Boolean = {p: Int -> p % 2 == 0}
    val body: (Int) -> String = {p: Int -> "$p is even"}
    val isEven: PartialFunction<Int, String> = PartialFunction(condition, body)
    val isEven2 = body.toPartialFunction(condition)
    val isOdd = ({p:Int -> "$p is odd"}).toPartialFunction { !condition(it) }
}