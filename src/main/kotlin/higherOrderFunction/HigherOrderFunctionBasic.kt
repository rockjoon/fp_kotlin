package higherOrderFunction

private fun higherOrderFunction1(function: () -> Unit): Unit {
    function
}

private fun higherOrderFunction2(): () -> Unit {
    return { println("hof2")}
}