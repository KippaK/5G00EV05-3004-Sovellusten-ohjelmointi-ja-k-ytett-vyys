/* Kotlin Essentials 1 */
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

/* Kotlin Essentials 2 */
// Vakiolista
fun static_listOf() {
    val viikonpäivät = listOf("Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai", "Sunnuntai")

    for (päivä in viikonpäivät) {
        println(päivä)
    }
}

// Muokattava lista
fun mutable_listOf() {
    val ostoslista = mutableListOf("Maito", "Leipä", "Juusto")

    ostoslista.add("Omena")
    ostoslista.add("Banaani")
    ostoslista.add("Kahvi")

    println("Ostoslista: $ostoslista")

    val etsittyTuote = "Juusto"
    if (ostoslista.contains(etsittyTuote)) {
        println("$etsittyTuote löytyy ostoslistalta.")
    } else {
        println("$etsittyTuote ei löydy ostoslistalta.")
    }

    ostoslista.remove("Leipä")
    println("Päivitetty ostoslista: $ostoslista")
}

// "when" avainsana
fun keyword_when() {
    val päivä = "Tiistai"

    when (päivä) {
        "Maanantai" -> println("Aloita viikko!")
        "Tiistai" -> println("Toinen päivä.")
        "Keskiviikko" -> println("Puoliväli viikosta.")
        "Torstai" -> println("Lähestytään viikonloppua.")
        "Perjantai" -> println("Viikonloppu on tulossa!")
        "Lauantai", "Sunnuntai" -> println("Nauti viikonlopusta!")
        else -> println("Ei ole viikonpäivä.")
    }
}
