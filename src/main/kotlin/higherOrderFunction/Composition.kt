package higherOrderFunction

fun main() {
    println(composedAddTwice(4))
    val addThree = { i: Int -> i + 3 }
    val twice = {i: Int -> i * 2 }
    val composed = addThree compose twice
    println(composed(4))
}

private fun addThree(i: Int) = i + 3

private fun twice(i: Int) = i * 2

private fun composedAddTwice(i: Int) = addThree(twice(i))

infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R = {
    gInput: G -> this(g(gInput))
}