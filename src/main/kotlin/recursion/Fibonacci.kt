package recursion

fun main() {
    println(fiboRecursive(7))
    println(fiboMemoization(7))
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