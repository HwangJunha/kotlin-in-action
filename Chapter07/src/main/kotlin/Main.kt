package com.around

import java.beans.PropertyChangeListener
import java.time.LocalDate

operator fun Char.times(count: Int) : String {
    return toString().repeat(count)
}

operator fun<T> MutableCollection<T>.plusAssign(element: T) {
    println("Adding $element")
    this.add(element)
}

operator fun Point.get(index: Int) : Int{
    return when(index){
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext() = current <= endInclusive
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

fun main() {
    var p1 = Point(1,2)
    val p2 = Point(20,40)
    val p3 = Point(10, 20)

    println(p1 + p2)
    println(p3 * 1.5)
    println('a'+3)

    p1+=p2
    println(p1)

    val list =  arrayListOf(1,2)
    list += 3
    val newList = list+listOf(4,5)
    println(newList)

    println(-p1)
    val person1 = Person("Alice", "Smith")
    val person2 = Person("Bob", "Johnson")
    println(person1 <= person2)

    val p = Point(10,20)
    println(p[0])
    println(p[1])

    val mutablePoint = MutablePoint(10,20)
    mutablePoint[1] = 42
    println(p)

    val rect = Rectangle(Point(10, 20), Point(20,30))
    println(Point(10,20) in rect)
    println(Point(5,5) in rect)

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)

    val newYear = LocalDate.ofYearDay(2024, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for(dayOff in daysOff) {
        println(dayOff)
    }

    val (name, ext) = splitFilename("example.txt")
    println(name)
    println(ext)

    val emailPerson = EmailPerson("junha")
    emailPerson.emails
    emailPerson.emails

    val salaryPerson = SalaryPerson("junha", 20, 2000)
    salaryPerson.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed " + "from ${event.oldValue} to ${event.newValue}")
        }
    )
    salaryPerson.age = 21
    salaryPerson.salary = 2100
}

