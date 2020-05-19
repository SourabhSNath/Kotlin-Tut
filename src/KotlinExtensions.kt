
fun main() {

    println("KFSHFLSKH LSFKJLK J".hasSpaces())

    val plant = GreenLeafyPlant(10)
    plant.println()
    val aPlant: AquariumPlant = plant
    println(aPlant.isGreen)
    aPlant.println()
}

//fun String.hasSpaces(): Boolean {
//    val found = this.find { it == ' ' }
//    return found != null
//}

// Compact version of the above
fun String.hasSpaces(): Boolean = find { it == ' ' } != null

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)

fun AquariumPlant.println() = println("Aquarium Plant")
fun GreenLeafyPlant.println() = println("Green Leafy Plant")

// Extension Property
val AquariumPlant.isGreen: Boolean
    get() = color == "Green"
