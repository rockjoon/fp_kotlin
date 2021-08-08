package recursion

fun main() {
    println(fiboDynamic(10, IntArray(100)))
}

private fun fiboDynamic(n: Int, fibo: IntArray): Int {
    fibo[0] = 0;
    fibo[1] = 1;
    for (i in 2..n) {
        fibo[i] = fibo[i - 2] + fibo[i - 1]
    }
    return fibo[n]
}