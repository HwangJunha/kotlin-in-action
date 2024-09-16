package com.around

fun alphabetWith() = with(StringBuilder()) {
    for(letter in 'A'..'Z') {
        this.append(letter)
    }
    append("\n Now I know the alphabet!")
    this.toString()
}
fun alphabetApply() = StringBuilder().apply {
    for(letter in 'A'..'Z') {
        append(letter)
    }
    append("\n Now I know the alphabet!")
}.toString()

fun main() {
    val peoples = listOf(Person("junha", 12), Person("jane", 19), Person("wane", 12))

    val names = peoples.joinToString (separator = " ", transform = { p: Person -> p.name })
    println(peoples.maxBy { p -> p.age })
    println(names)

    val list = peoples.filter{it.age == peoples.maxBy(Person::age).age}
    println(list)

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    println(peoples.all(canBeInClub27))
    println(peoples.count(canBeInClub27))

    println(peoples.groupBy { it.age })
    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry pratchett")),
        Book("Good Omens", listOf("Terry pratchett", "Neil Gaiman")),
    )
    println(books.flatMap { it.author }.toSet())
    val filterList = peoples.asSequence()
        .map(Person::name)
        .filter{it.startsWith("j")}
        .toList()
    println(filterList)

    listOf(1,2,3,4)
        .asSequence()
        .map {print("map($it)"); it*it}
        .filter { print("filter($it)"); it % 2 == 0 }
        .toList()
    val natureNumbers = generateSequence(1) { it + 1 }
    val numberTo100 = natureNumbers.takeWhile{it <= 100}
    println(numberTo100.sum())
    println(alphabetWith())
    println(alphabetApply())

}