package higherOrderFunction

fun main() {

    val isEven = PartialFunction<Int, String>({ it % 2 == 0 }, { "$it is even" })
    if(isEven.isDefinedAt(100))
        println(isEven(100))
    else
        println("not even")

    println()

    val condition: (Int) -> Boolean = { it % 2 == 0}
    val body: (Int) -> String = { "$it is even" }

    val isEven2 = body.toPartialFunction(condition)

    if(isEven2.isDefinedAt(100))
        println(isEven2(100))
    else
        println("not even")
}


