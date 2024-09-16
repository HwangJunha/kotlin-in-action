package com.around

import java.io.BufferedReader
import java.io.IOException
import java.io.StringReader

fun printAllCaps(s: String?){
    val allCaps: String? = s?.uppercase()
    println(allCaps)
}

fun strLen(s: String) : Int = s?.length ?: 0

fun strLenSafe(s: String?) = s?.length ?: 0

fun managerName(employee: Employee) : String? = employee.manger?.name

fun foo(s: String?){
    val t: String = s ?: ""
}
fun ignoreNulls(s: String?){
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("sending email to $email")
}
fun<T: Any> printHashCode(t: T){
    println(t.hashCode())
}

fun showProgress(progress: Int) {
    val precent = progress.coerceIn(0, 100)
    println("We're $precent % (100%) done")
}

fun readNumbers(readr: BufferedReader) : List<Int?> {
    val result = ArrayList<Int?>()
    for (line in readr.lineSequence()) {
        try{
            val number = line.toInt()
            result.add(number)
        }catch(e : NumberFormatException){
            result.add(null)
        }
    }
    return result
}
fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    var sumOfValidNumber = 0
    var invalidNumbers = 0
    for(number in numbers){
        if(number != null){
            sumOfValidNumber += number
        }else{
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValidNumber")
    println("Invalid numbers: $invalidNumbers")
}

fun main() {
    val ceo = Employee("Da boss", null)
    val developer = Employee("Dan Joseph", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val person = Person("Dmitry", null)
    println(person.countryName())

    println(strLenSafe(null))
//    println(ignoreNulls(null))
    val email : String? = "junha@example.com"
    email?.let { sendEmailTo(it)}
    val emila2 : String? = null
    emila2?.let { sendEmailTo(it) }

    val person2: Person? = Person("Dmitry", null)
    person2?.let { sendEmailTo(it.name) }
//    printHashCode(null)
    showProgress(100)

    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
    println(Person("Sam", 35).isOlderThan(Person("Amy")))
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)

}