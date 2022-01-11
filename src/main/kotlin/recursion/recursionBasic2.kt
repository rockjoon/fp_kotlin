package recursion

fun main() {
    println(basicSum(5))
    println(maximum2(listOf(1, 3, 2, 8, 9)))
    println(maximum3(listOf(1, 3, 2, 8, 9)))
    println(reverse2("abcd"))
    println(reverse3("abcd"))
    println(toBinary2(10))
    println(replicate2(3, 5))
    println(replicate3(5, 1))
}

fun basicSum(n: Int): Int {
    return when {
        n < 0 -> 0
        else -> n + basicSum(n - 1)
    }
}

// list 의 최댓값 구하기 : java-like
fun maximum2(list: List<Int>): Int {
    return when {
        list.isEmpty() -> throw NullPointerException()
        list.size == 1 -> list.head()
        else -> {
            if (list.head() > maximum2(list.tail()))
                return list.head()
            maximum2(list.tail())
        }
    }
}

// fp-like
fun maximum3(list: List<Int>): Int = when {
    list.isEmpty() -> error("empty list")
    list.size == 1 -> list.head()
    else -> {
        val head = list.head()
        val maxValue = maximum3(list.tail())
        if (head > maxValue) head else maxValue
    }
}

// 입력된 문자열을 뒤집기
fun reverse2(input: String): String = when {
    input.isEmpty() -> error("empty input")
    input.length == 1 -> input.first().toString()
    else -> {
        val head = input.first()
        val reversed = reverse2(input.tail())
        reversed + head
    }
}

// simple
fun reverse3(input: String): String = when {
    input.isEmpty() -> ""
    else -> reverse3(input.tail()) + input.first()
}

// 10진수를 2진수로 변환
fun toBinary2(input: Int): String = when (input) {
    0 -> "0"
    1 -> "1"
    else -> toBinary2(input / 2) + (input % 2).toString()
}


// num 을 size 개 만큼 갖는 리스트 반환
fun replicate2(size: Int, num: Int): List<Int> = when {
    size < 1 -> error("incorrect input")
    size == 1 -> listOf(num)
    else -> listOf(num).plus(replicate2(size - 1, num))
}

// simplify
fun replicate3(size: Int, num: Int): List<Int> = when {
    size <= 0 -> listOf()
    else -> listOf(num) + replicate2(size - 1, num)
}
