// Funktiot
fun add(num1: Int, num2: Int): Int {
    return  num1 + num2
}

// Luokat ja Metodit
class Car(val brand: String, val year: Int) {
    fun printCarInfo() {
        println("Car brand: $brand, Year: $year")
    }
}

// Null safety ja Elvis operaattori
fun nullSafety() {
    val myString: String? = null

    val result = myString ?: "Default Value"

    println(result)
}

// Extension funktiot
fun String.addExclamation(): String {
    return this + "!"
}
