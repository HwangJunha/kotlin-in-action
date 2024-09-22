package com.around

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.full.memberProperties


fun serialize(obj: Any): String = buildString{ serializeObject(obj)}

private fun StringBuilder.serializeObject(obj: Any){
    val kClass = obj.javaClass.kotlin
    val properties = kClass.memberProperties

//    properties.joinToString(
//        this, prefix = "{", postfix = "}"
//    ) { prop ->
//        serializeString(prop.name)
//        append(": ")
//        serializePropertyValue(prop.get(obj))
//    }
}

fun main() {
    val person = Person("junha", 10)
    val json = """{"name":"junha", "age" : "10"}"""
    println(Json.encodeToString(person))
    println(Json.decodeFromString<Person>(json))
}