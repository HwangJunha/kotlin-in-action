package com.around

class Address(val street: String, val city: String, val zipcode: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val age: Int? = null, val company: Company? = null){
    fun isOlderThan(other: Person): Boolean?{
        if(age == null || other.age == null){
            return null
        }
        return age > other.age
    }
}

fun Person.countryName() = company?.address?.country ?: "Unknown"