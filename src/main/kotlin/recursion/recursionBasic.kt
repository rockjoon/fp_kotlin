package recursion

fun main() {
    println(sum(10))
    println(power(2, 10))
    println(factorial(5))
    println(max(listOf(4, 8, 11, 5, 61)))
    println(reverse("abcd"))
    println(toBinary(5))
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
    return when {
        input == 0 -> ""
        else -> {
            val binary = (input % 2).toString()
            return toBinary(input / 2) + binary
        }
    }
}