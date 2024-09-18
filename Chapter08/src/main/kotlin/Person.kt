package com.around

data class Person(
    val firstName : String,
    val lastName: String,
    val phoneNUmber: String?
)
class ContactListFilters{
    var prefix : String = ""
    var onlyWithPhoneNumber : Boolean = false
    fun getPredicate() : (Person) -> Boolean {
        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }
        if(!onlyWithPhoneNumber){
            return startsWithPrefix
        }
        return {startsWithPrefix(it) && it.phoneNUmber != null}

    }
}