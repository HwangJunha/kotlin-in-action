package com.around

interface Matcher<T> {
    fun test(value: T) : Boolean
}

class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) : Boolean {
        if(!value.startsWith(prefix))
            throw AssertionError("String $value does not start with $prefix")
        return true
    }
}