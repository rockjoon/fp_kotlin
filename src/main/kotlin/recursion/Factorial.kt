package recursion

fun main() {
    println(factorialRecursive(7))
    println(factorialMemoization(7))
    println(factorialFP(7))
}

fun factorialRecursive(n: Int): Int {
    return when (n) {
        0 -> 1
        else -> n * factorialRecursive(n - 1)
    }
}

var memoFactorial = Array(100) { -1 }
fun factorialMemoization(n: Int): Int {
    return when {
        n == 0 -> 1
        memoFactorial[n] != -1 -> memoFactorial[n]
        else -> {
            memoFactorial[n] = n * factorialMemoization(n - 1)
            memoFactorial[n]
        }
    }
}

fun factorialFP(n: Int) = factorialFP(n, 1)

fun factorialFP(n: Int, result: Int): Int = when (n) {
    0 -> result
    else -> factorialFP(n - 1, n * result)
}