package com.around.button

import com.around.Clickable
import com.around.Focusable

class Button: Clickable, Focusable {
    override fun click() = print("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}