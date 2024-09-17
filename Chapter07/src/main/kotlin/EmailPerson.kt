package com.around


class EmailPerson(val name: String) {
//    private var _emails : List<Email>? = null
//    val emails: List<Email>
//        get(){
//            if(_emails == null){
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }
//
    private fun loadEmails(emailPerson: EmailPerson): List<Email> {
        println("Load emails for ${emailPerson.name}")
        return listOf(Email("tarot1415@gmail.com",emailPerson.name))
    }

    val emails by lazy {loadEmails(this)}

}