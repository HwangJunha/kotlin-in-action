package com.around

data class Point(val x: Int, val y: Int){
    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is Point) return false
        return this.x == other.x && this.y == other.y
    }
}
data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, values: Int) {
    when(index){
        0 -> x = values
        1 -> y = values
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }

}

operator fun Point.plus(other: Point) : Point {
    return Point(x + other.x, y + other.y)
}
operator fun Point.times(scale: Double) : Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}
operator fun Point.unaryMinus() : Point {
    return Point(-x, -y)
}