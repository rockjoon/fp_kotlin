package calculator

fun main() {
    val fpCalculator = FpCalculator()
    val result1 = fpCalculator.calculate(1, 2) { x, y -> x + y }
    val result2 = fpCalculator.calculate(1, 2) { x, y -> x - y }
    println(result1)
    println(result2)
}

class FpCalculator {

    fun calculate(no1: Int, no2: Int, calculator: (Int, Int) -> Int): Int {
        return calculator(no1, no2)
    }

}