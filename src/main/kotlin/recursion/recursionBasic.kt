package recursion

fun main() {
    println(sum(10))
    println(power(2, 10))
    println(factorial(5))
    println(max(listOf(4, 8, 11, 5, 61)))
    println(reverse("abcd"))
    println(toBinary(18))
    println(replicate(4, 5))
    println(take(4, listOf(1, 2, 3, 4, 5)))
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
        else -> n * factorial(n - 1)
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
    return when {
        input.length == 1 -> input
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