package collection

import collection.FunList.*

sealed class FunList <out T> {
    object Nil : FunList<Nothing>() { override fun toString() = "Nil" }
    data class Cons<out T>(val head: T, val tail: FunList<T>) : FunList<T>()
}

fun <T> FunList<T>.addHead(head: T): FunList<T> {
    return Cons(head, this)
}

fun <T> FunList<T>.appendTail(value: T): FunList<T> {
    println(this)
    return when(this) {
        Nil -> Cons(value, Nil)
        is Cons -> Cons(head, tail.appendTail(value))
    }
}

fun main() {
    val list: FunList<Int> = Cons(1, Cons(2, Nil))
    val added = list.addHead(0)
    val appended = list.appendTail(3)
    println(appended)

    val doubleList: FunList<Double> = Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Nil))))

}

