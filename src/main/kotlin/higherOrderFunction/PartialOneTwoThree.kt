package higherOrderFunction

fun main() {

    val condition: (Int) -> Boolean = { it in 1..3 }
    val body: (Int) -> String = {
        when (it) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            else -> throw IllegalArgumentException()
        }
    }

    val oneTwoThree = PartialFunction(condition, body)
    println(oneTwoThree(2))

    body.toPartialFunction(condition)
}