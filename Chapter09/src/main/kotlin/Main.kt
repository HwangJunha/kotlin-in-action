package com.around

import kotlin.random.Random

fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable {
        if(!seq.endsWith('.')){
            seq.append('.')
        }
    }

fun printSum(c: Collection<Int>){
    if(c is List<Int>){
        println(c.sum())
    }
}

inline fun <reified T> isA(value: Any) = value is T

fun printContents(list: List<Any>){
    println(list.joinToString())
}

fun <T> copyData(source: MutableList<out T>, destination: MutableList<T>) {
    for(item in source){
        destination.add(item)
    }
}


fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..12))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
    println(printSum(listOf(1, 2, 3, 4, 5)))

    println(isA<String>("one"))
    println(isA<String>(2))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

    println(printContents(listOf("one", "two", "three")))

    val ints = mutableListOf(1, 2, 3, 4, 5)
    val anyItem = mutableListOf<Int>()
    copyData(source = ints, destination = anyItem)
    println(anyItem)

    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')
    val unknownElements: MutableList<*> = if(Random.nextBoolean()) list else chars

    println(unknownElements);
}