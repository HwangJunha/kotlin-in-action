package com.around

interface Producer<out T> {
    fun produce(): T
}