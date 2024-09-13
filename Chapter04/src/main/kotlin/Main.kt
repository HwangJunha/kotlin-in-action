package com.around

import com.around.button.Button
import com.around.user2.User
fun main() {
    val button = Button()
    button.click()
    button.showOff()
    button.setFocus(true)

    val talkativeButton = TalkativeButton()

    val user = User("Alice")
    user.address = "Elsenheimerstresss 57, 80687 Myenchen"

}