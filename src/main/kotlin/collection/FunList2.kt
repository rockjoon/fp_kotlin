package collection

import collection.FunList2.*

sealed class FunList2<out T> {
    object Nil : FunList2<Nothing>() { override fun toString(): String ="Nil" }
    data class Cons<out T>(val head: T, val tail: FunList2<T>) : FunList2<T>()
}

fun <T> FunList2<T>.addHead(head: T) : FunList2<T> = Cons(head, this)

fun <T> FunList2<T>.appendTail(value: T) : FunList2<T> {
    return when (this) {
        FunList2.Nil -> Cons(value, Nil)
        is Cons -> Cons(head, tail.appendTail(value))
    }
}

fun main() {
    val funList = Cons(1, Cons(2, Nil))
    println(funList.addHead(0))
}