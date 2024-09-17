package com.around

data class NameComponets(val name: String, val extension: String)

fun splitFilename(fullName: String) : NameComponets{
    val result = fullName.split(".", limit = 2)
    return NameComponets(result[0], result[1])
}