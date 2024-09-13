package com.around

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech(){ // 오류 public 멤버가 자신의 internal 수신 타입이 TalkativeButton을 노출함
//    yell() // yell에 접근할 수 없음
//    whisper() //whisper에 접근할 수 없음
//}