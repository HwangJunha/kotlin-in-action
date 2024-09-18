package com.around

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

fun performRequest(
    url : String,
    callback: (code: Int, content: String) -> Unit
){

}

fun twoAndThree(operation: (Int, Int) -> Int){
    val result = operation(2,3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean) : String {
    val sb = StringBuilder()
    for(index in 0 until length) {
        val element = get(index)
        if(predicate(element)) sb.append(element)

    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
//    transform: (T) -> String = {
//        it.toString()
//    }
    transform: ((T) -> String)? = null
) : String {
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if(index > 0 )result.append(separator)
//        result.append(transform(element))
        val str = transform?.invoke(element) ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

fun List<SiteVisit>.averageDurationFor(os: OS) =
    filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(predicate : (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun foo(l: Lock){
    synchronized(1){
        println("Action")
    }
    println("After sybc")
}

fun readFirstLineFromFile(path: String) : String{
    BufferedReader(FileReader(path)).use{ br -> return br.readLine()}
}

fun lookForAlice(people: List<Person>){
    people.forEach{
        if(it.firstName == "Alice"){
            return@forEach
        }
        println("Not alice")
    }
    println("Alice might be somewhere")
}

fun main() {
    var canReturnNull: (Int, Int) -> Int? = {x,y -> null}
    var funOrNull: ((Int, Int) -> Int)? = null

    val url = "http://kotl.in"
    performRequest(url){code, content -> println(content)}
    performRequest(url){code, page -> println(page)}

    twoAndThree{a,b -> a+b}
    twoAndThree{a,b -> a*b}

    println("ab1d".filter { it in 'a' .. 'z' })
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString(""))
    println(letters.joinToString{it.lowercase()})
    println(letters.joinToString(separator="! ", postfix = "! ", transform = {it.uppercase()}))

    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")

    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Dmitry", "Jemerov", null),
        Person("Svetlana", "Isakova", null),
        )
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))

    val averageWindowsDuration = log
        .filter { it.os == OS.WINDOWS }
        .map(SiteVisit::duration)
        .average()
    println(averageWindowsDuration)

    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))

    val averageMobileDuration = log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average()

    println(averageMobileDuration)
    println(log.averageDurationFor{
        it.os in setOf(OS.WINDOWS, OS.MAC)
    })
    println(log.averageDurationFor{
        it.os == OS.IOS && it.path == "/signup"
    })

    lookForAlice(listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Alice", "Jemerov", "123-4567"),
        Person("Junha", "Jemerov", "123-4567")
    ))
}