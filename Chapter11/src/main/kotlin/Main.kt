package com.around

import kotlinx.html.*
import kotlinx.html.stream.createHTML



fun createSimpleTable() = createHTML()
    .table{
        tr{
            td{+"cell"}
        }
    }

fun createAnotherTable() = createHTML()
    .table {
        val numbers = mapOf(1 to "one", 2 to "two", 3 to "three")
        for((num, string) in numbers)
        tr{
            td{+"$num"}
            td {+"$string"}
        }
    }

fun buildString(
    builderAction: (StringBuilder) -> Unit
) : String{
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString2(
    builderAction: StringBuilder.() -> Unit
) : String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

fun buildString3(builderAction: StringBuilder.() -> Unit) : String = StringBuilder().apply(builderAction).toString()

fun buildDropdown() = createHTML().div(classes = "dropdown"){
    button(classes = "btn dropdown-toggle"){
        +"Dropdown"
        span(classes = "caret")
    }
    ul(classes = "dropdown-menu"){
        li{a("#") {+"Action"}}
        li{a("#") {+"Another action"}}
        li{role = "separator"; classes = setOf("divider")}
        li{classes = setOf("dropdown-header"); + "Header"}
        li{a("#") {+"Separated link"}}

    }
}

fun UL.item(href: String, name: String) = li{a(href){+name} }
fun UL.divider() = li{role="separator"; classes = setOf("divider")}
fun UL.dropdownHeader(text: String) = li{classes = setOf("dropdown-header"); +text}
fun DIV.dropdownMenu(block: UL.() -> Unit) = ul("dropdown-menu", block)
//fun StringBuilder.dropdown(
//    block: DIV.() -> Unit
//) : String = createHTML().div("dropdown", block)
//fun buildDropdownExample() = createHTML().dropdown{
//    dropdownButton{+"Dropdown"}
//    dropdownMenu{
//        item("#", "Action")
//        item("#", "Action")
//        divider()
//        dropdownHeader("Header")
//        item("#", "Separated link")
//    }
//}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)


fun main() {
    println(createSimpleTable())
    println(createAnotherTable())

    val s = buildString{
        it.append("Hello,")
        it.append("World")
    }
    println(s)

    val s2 = buildString2{
        this.append("Hello,")
        append("World")
    }
    println(s2)

    val appendExcel : StringBuilder.() -> Unit = {this.append("!")}
    val stringbuilder = StringBuilder("Hi")
    stringbuilder.appendExcel()
    println(stringbuilder)
    println(buildString2(appendExcel))

    val map = mutableMapOf(1 to "one")
    map.apply { this[2] = "two" }
    with(map){this[3] = "three"}
    println(map)

    val bavarianGreeter = Greeter("Servus")
    bavarianGreeter("Dmitry")

    val i1 = Issue("IDEA-154446", "IDEA", "Bug", "Major", "Saven settings failed")
    val i2 = Issue("KT-12183", "Kotlin", "Feature", "Normal", "Intention: convert several calls on the same receiver to with/apply")
    val predicate = ImportantIssuePredicate("IDEA")
    for(issue in listOf(i1, i2).filter(predicate)){
        println(issue.id)
    }
    val a = "kot123"
    println(a should startWith("kot"))

    println(1.days.ago)
    println(1.days.fromNow)

}