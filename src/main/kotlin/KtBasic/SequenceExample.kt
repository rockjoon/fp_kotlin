package KtBasic

fun main() {
    generateSequenceTest()
    sequenceOfTest()
    sequencePlusTest()
}

private fun generateSequenceTest() {
    val infinite = generateSequence(0) { it + 1 }
    infinite.take(5).forEach { print("$it ") }
    println()
}

private fun sequenceOfTest() {
    val sequence = sequenceOf(1, 2, 3, 5)
    sequence.forEach { print("$it ") }
    println()
}

private fun sequencePlusTest() {
    val sequence = sequenceOf(1, 2, 3, 5)
    val plus = sequence.plus(6)
    val plusArray = plus.plus(arrayOf(7,8))
    plus.forEach { print("$it ") }
    println()
    plusArray.forEach { print("$it ") }
    println()
}