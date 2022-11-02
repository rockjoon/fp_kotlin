package recursion

fun main() {
//    println(aPower(2, 10))
    println(rPower(2, 10))
}

// 재귀로 합계 구하기
private fun sum(n: Int): Int = when {
    n < 0 -> 0
    else -> n + sum(n - 1)
}

// 재귀로 n제곱 구하기
private fun power(x: Int, n: Int): Int = when {
    n < 1 -> 1
    else -> x * power(x, n - 1)
}

// 재귀로 팩토리얼 구하기
private fun factorial(n: Int): Int {
    return when {
        n < 1 -> 1
        else -> n * factorialRecursive(n - 1)
    }
}

fun List<Int>.head() = first()
fun List<Int>.tail() = drop(1)

// 재귀로 최대값 구하기
private fun max(list: List<Int>): Int {
    return when {
        list.isEmpty() -> error("잘못된 리스트입니다.")
        list.size == 1 -> list[0]
        else -> {
            val head = list.head()
            val tail = max(list.tail())
            if (head > tail) head else tail
        }
    }
}

fun String.head() = first()
fun String.tail() = drop(1)

// 입력한 값의 순서를 바꾸기
private fun reverse(input: String): String {
    return when (input.length) {
        1 -> input
        else -> {
            val head = input.head()
            val tail = reverse(input.tail())
            return tail + head
        }
    }
}

// 10진수를 2진수로 변환
private fun toBinary(input: Int): String {
    return when (input) {
        0 -> ""
        else -> {
            val binary = (input % 2).toString()
            return toBinary(input / 2) + binary
        }
    }
}

// element를 n개 가지는 리스트를 반환
private fun replicate(count: Int, element: Int) : List<Int> {
    return when (count) {
        1 -> listOf(element)
        else -> replicate(count - 1, element).plus(element)
    }
}

// 입력 받은 리스트에서 n만큼의 값을 꺼내 오는 함수
private fun take(n: Int, list: List<Int>) : List<Int> {
    return when {
        n < 1 -> error("wrong input")
        n == 1 -> list.subList(0, 1)
        else -> take(n - 1, list).plus(list[n - 1])
    }
}

// 입력값 n이 리스트에 존재하는지 확인하는 함수
private fun contains(n: Int, list: List<Int>) : Boolean {
    return when {
        list.isEmpty() -> false
        else -> list.head() == n || contains(n, list.tail())
    }
}

//두 개의 리스트를 입력 받아 하나의 리스트로 조합하는 함수
private fun zip(list1: List<Int>, list2: List<Int>): List<Pair<Int, Int>> {
    return when{
        list1.isEmpty() || list2.isEmpty() -> emptyList()
        else -> {
            listOf(Pair(list1.head(), list2.head())) + zip(list1.tail(), list2.tail())
        }
    }
}

private fun quicksort(list: List<Int>): List<Int> = when(list.size) {
    0 -> emptyList()
    else -> {
        val pivot = list.first()
        val (small, big) = list.tail().partition { it < pivot }
        quicksort(small) + listOf(pivot) + quicksort(big)
    }
}
private fun aFactorial(n: Int): Int = when(n) {
    1 -> 1
    else -> n * aFactorial(n - 1)
}

private tailrec fun rFactorial(n: Int, acc: Int = 1): Int = when(n) {
    0 -> acc
    else -> rFactorial(n-1, n * acc)
}

private fun aPower(no: Int, count: Int): Int {
    println("count: $count")
    return when (count) {
        0 -> 1
        else -> no * aPower(no, count - 1)
    }
}

private tailrec fun rPower(no: Int, count: Int, acc: Int = 1): Int {
    println("count: $count, acc: $acc")
    return when(count) {
        0 -> acc
        else -> rPower(no, count - 1, no * acc)
    }
}

private fun aMaximum(list: List<Int>): Int {
    return when (list.size) {
        1 -> list.first()
        else -> {
            val head = list.first()
            val maximum = aMaximum(list.tail())
            println("$head, $maximum")
            if (head > maximum) head else maximum
        }
    }
}

private tailrec fun rMaximum(list: List<Int>, acc: Int = Int.MIN_VALUE): Int = when(list.size) {
    1 -> list.first()
    else -> {
        val maximum = if (list.first() > acc) list.first() else acc
        rMaximum(list.tail(), maximum)
    }
}

private fun aReverse(str: String): String = when(str.length) {
    0 -> ""
    else -> aReverse(str.tail()) + str.head()
}

private tailrec fun rReverse(str: String, acc: String = ""): String = when(str.length) {
    0 -> acc
    else -> rReverse(str.tail(), str.head() + acc)
}

private fun aToBinary(n: Int): String {
    return when(n) {
        0 -> "0"
        1 -> "1"
        else -> aToBinary(n/2) + (n%2).toString()
    }
}

private tailrec fun rToBinary(n: Int, acc: String = ""): String {
    println("n : $n, acc: $acc")
    return when {
        n < 1 -> acc
        else -> rToBinary(n/2, (n%2).toString() + acc)
    }
}

private fun aReplicate(count: Int, no: Int): List<Int> {
    println("c: $count")
    return when(count) {
        1 -> listOf(no)
        else -> listOf(no) + aReplicate(count - 1, no)
    }
}

private tailrec fun rReplicate(count: Int, no: Int, acc: List<Int> = emptyList()): List<Int> {
    println("count: $count, acc: $acc")
    return when(count) {
        0 -> acc
        else -> rReplicate(count - 1, no, listOf(no) + acc)
    }
}