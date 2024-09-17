package com.around

class SalaryPerson(val name: String, age: Int, salary: Int) : PropertyChangeAware(){
//    var age: Int = age
//    set(newValue) {
//        val oldValue = field
//        field = newValue
//        changeSupport.firePropertyChange("age", oldValue, newValue)
//    }
//    var salary: Int = salary
//    set(newValue) {
//        val oldValue = field
//        field = newValue
//        changeSupport.firePropertyChange("salary", oldValue, newValue)
//    }

    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}