package com.around
import strings.*

var opCount = 0
fun performOperation(){
    opCount++
}
fun reportOperationCount() {
    println("Operation perfoemed $opCount times")
}

fun parsePath(path: String) : String {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfter("/")
    val fileName = fullName.substringBefore(".")
    val extension = fullName.substringAfterLast(".");
    println("Dif: $directory, name: $fileName, ext: $extension")
    return fullName
}


fun main(args: Array<String>) {

    val numberList = listOf(1,2,3)

    println(joinToString(numberList, separator = " ", prefix= " ", postfix = "."))


    performOperation()
    reportOperationCount()

    println("Kotlin".lastChar())

    val view: View = Button()
    view.click()
    val list = listOf("args: ", *args)
    println(list)
    val (number, name) = 1 to "one"
    println("$number to $name")

    println("12.345-6.A".split(".", "-"))

    val fullName = parsePath("/Users/Junha/kotlin-book-chapter.adoc")
    println("fullName: $fullName")

    val user = User(1, "jun", "서울시")
    user.saveUser(user)

}