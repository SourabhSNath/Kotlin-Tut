package Aquarium.generics

fun main() {
    genericExample()
}


fun genericExample() {

    // Water supply of type TapWater
    val aquarium = Aquarium(TapWater())

    aquarium.waterSupply.addChemicalCleaners()

    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    aquarium2.addWater()

    aquarium2.hasWaterSupplyOfType<TapWater>() // False
    aquarium2.waterSupply.isOfType<LakeWater>() // True
}


open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {

    fun addChemicalCleaners() {
        needsProcessed = false //water cleaned
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {

    fun filter() {
        needsProcessed = false
    }
}

/**
 * By default T is Any? i.e <T : Any?>, so null can be passed here.
 * To prevent passing null use <T : Any>
 *
 * Here it's making sure the type is always related to WaterSupply
 *
 * ---------------------------------------------------------------
 * - **Out (covariant type)**
 *
 * If your generic class only use the generic type as output of it’s function/s, then `out` is used i.e.
 *
 * interface Production<out T> {
 *   fun produce(): T
 * }
 *
 *
 * - **In (contravariance type)**
 *
 * If your generic class only use the generic type as input of it’s function/s, then `in` is used i.e.
 *
 *
 * interface Consumer<in T> {
 *   fun consume(item: T)
 * }
 */

class Aquarium<out T : WaterSupply>(val waterSupply: T) {

    // Check is the water supply needs to be processed,
    // else throw exception with the msg
    fun addWater() {
        check(!waterSupply.needsProcessed) { "water supply needs to be processed" }
        println("adding water from ${waterSupply.javaClass.simpleName}")
    }

    // Return true if T is R
    // Reified is to tell that its real
    // It says: Declare a type parameter R but make it a real type
    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

/**
 * Generic function, makes sure the aquarium passed has a Type of WaterSupply
 * Otherwise specifying it as aquarium: Aquarium<WaterSupply> would only accept WaterSupply class
 */
fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean")
}

/**
 * Extension Function
 */
inline fun <reified T : WaterSupply> WaterSupply.isOfType() {
    println(this is T)
}

// Take any aquarium <*>
inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType2() = waterSupply is R