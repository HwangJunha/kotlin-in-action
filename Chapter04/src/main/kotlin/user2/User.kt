package com.around.user2

class User(val name : String) {
    var address: String = "unspecified"
        set(value: String){
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}