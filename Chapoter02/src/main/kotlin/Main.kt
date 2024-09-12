package com.around

fun getMnemonic(color: Color) =
    when(color){
        Color.RED, Color.ORANGE, Color.YELLOW -> "Richard"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)){
        setOf(Color.RED, Color.YELLOW) -> "ORANGE"
        setOf(Color.YELLOW, Color.BLUE) -> "GREEN"
        setOf(Color.BLUE, Color.VIOLET) -> "INDIGO"
        else -> throw Exception("Dirty color")
    }
fun eval(e: Expr) : Int =
    when(e){
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun fizzBuzz(i: Int) = when{
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i "
}

fun main() {
    println(mix(Color.BLUE, Color.RED))
    println(eval(Sum((Sum(Num(1), Num(2))), Num(4))))
    val oneToTen = 1..10
    for(i in 100 downTo 1 step 2){
        println(fizzBuzz(i))
    }
}
