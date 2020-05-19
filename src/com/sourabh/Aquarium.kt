package com.sourabh

open class Aquarium(var length: Int = 100, var width: Int = 20, open var height: Int = 40) {

    open var volume: Int
        get() = width * length * height / 1000
        set(value) {
            height = (value / 1000) / (width * length)
        }

    open val shape: String = "Rectangle"

    // returns 90% of the volume of the Aquarium
    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("Aquarium init")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    }

    /**
     *  Secondary constructor,
     *  All secondary constructor needs to call the primary constructor using this() or
     *  by calling another secondary constructor
     *  all init blocks of the primary constructor will be used
     */
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println(shape)
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water / volume * 100.0}% full)")
    }

}