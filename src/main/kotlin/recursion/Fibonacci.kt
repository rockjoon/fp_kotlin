package recursion

fun main() {
    println(fiboRecursive(7))
    println(fiboMemoization(7))
    println(fiboFPBad(7, Array(100){ -1}))
    println(fiboFP(4))
}

fun fiboRecursive(n: Int): Int {
    return when(n) {
        0 -> 0
        1 -> 1
        else -> fiboRecursive(n-2) + fiboRecursive(n-1)
    }
}

var memoFibonacci = Array(100) { -1 }
fun fiboMemoization(n: Int): Int {
    return when {
        n == 0 -> 0
        n == 1 -> 1
        memoFibonacci[n] != -1 -> memoFibonacci[n]
        else -> {
            memoFibonacci[n] = fiboMemoization(n - 2) + fiboMemoization(n - 1)
            memoFibonacci[n]
        }
    }
}

fun fiboFPBad(n: Int, cache: Array<Int>): Int = when {
    n == 0 -> 0
    n == 1 -> 1
    cache[n] != -1 ->  cache[n]
    else -> {
        cache[n] = fiboFPBad(n - 2, cache) + fiboFPBad(n - 1, cache)
        cache[n]
    }
}

fun fiboFP(n: Int) = fiboFP(n, 0, 1)

tailrec fun fiboFP(n: Int, first: Int, second: Int): Int {
    println("fibo($n, $first, $second)")
    return when (n) {
        0 -> first
        1 -> second
        else -> fiboFP(n - 1, second, first + second)
    }
}
