package com.around

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservableProperty(
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(thisRef: SalaryPerson, property: KProperty<*>): Int = propValue
    operator fun setValue(thisRef: SalaryPerson, property: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

}