package com.around

import com.around.button.Button
import com.around.user2.User
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun countClicks(window: Window) {
    var clickCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }
    })
}

fun main() {
//    val button = Button()
//    button.click()
//    button.showOff()
//    button.setFocus(true)
//
//    val talkativeButton = TalkativeButton()
//
//    val user = User("Alice")
//    user.address = "Elsenheimerstresss 57, 80687 Myenchen"

//    val client1 = Client("junha", 123)
//    val client2 = Client("junha", 123)
//    println(client1 == client2)
//    print(client1)

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 3))
    println("${cset.objectsAdded} objects were added, ${cset.size} were added")

    val persons = listOf(Person("Alice"), Person("Bob"), Person("Carol"))

    println(persons.sortedWith(Person.NameComparator))

    var listener = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {}
        override fun mouseEntered(e: MouseEvent) {}
    }
}