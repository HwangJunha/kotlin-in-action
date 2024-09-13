package com.around

open class RichButton : Clickable {

    fun disable() {} //하위 클래스가 이 메서드를 오버라이드 할 수 없다.

    open fun animate() {} // 이함수는 열려있다. 하우 ㅣ클래스에서 이 메서드를 오러바이드 해도 된다.

    override fun click() {} // 함수는 열려있는 메서드를 오버라이드 한다. 오버라이드한 메서드는 기본적으로 열려 있다. final 키워드를 붙일시 닫을 수 있다.

}