import kotlin.random.Random

fun main() {
    feedTheFish()
}

fun feedTheFish() {
    val day = randomDay()
    val food = randomFood()
    println("Today is $day and the fish ate $food")
    println("Change water: ${shouldChangeWater(day)}")
}

/**
 * Default values:  temperature: Int = 22, dirty : Int = 20
 * The default value can also be a function: temperature: Int = getTemperatureSensorData()
 * the function used for default value
 * shouldn't perform heavy operations otherwise it may slow down the program
 */
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isSunday(day) -> true
        isTooHot(temperature) -> true
        isTooDirty(dirty) -> true
        else -> false
    }
}

/**
 * Compact functions, doesn't need return keyword and type
 */
fun isTooHot(temperature: Int) = temperature > 30
fun isTooDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday" || day == "Monday"

fun randomDay(): String {
    val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val random = Random.nextInt(days.size)
    return days[random]
}

fun randomFood(): String {
    val foods = arrayOf("Golder guild fish food", "Ki Medicine fish food", "Hidden fish food")
    return foods[Random.nextInt(foods.size)]
}

