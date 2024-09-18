package com.around

open class Animal {
    fun feed(){}

}
class Herd<out T: Animal>{
    val size: Int
        get() =  Math.min(size, 3)
    operator fun get(i: Int): T =  get(i)
}

fun feedAll(animals: Herd<Animal>) {
    for(i in 0 until animals.size){
        animals[i].feed()
    }
}

class Cat: Animal(){
    fun cleanLitter(){
        println("Clean litter")
    }
}
fun takeCareOfCats(cats: Herd<Cat>){
    for(i in 0 until cats.size){
        cats[i].cleanLitter()
    }
    feedAll(cats)
}