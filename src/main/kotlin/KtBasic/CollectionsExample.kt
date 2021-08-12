package KtBasic

fun main() {
    println(dropTest(listOf(1, 2, 3, 4)))
}

fun dropTest(list: List<Int>): List<Int> {
    return list.drop(2)
}
