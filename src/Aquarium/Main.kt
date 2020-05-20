package com.sourabh

import com.sourabh.decor.makeDecoration

fun main() {

    buildAquarium()
    makeFish()
    makeDecoration()
    val color = KColor.BLUE
    println(color.ordinal)
    println(color.color)
}

fun buildAquarium() {
    val aquarium = Aquarium()
    aquarium.height = 120
    aquarium.printSize()

    println()
    val aquarium2 = Aquarium(100)
    aquarium2.volume = 80
    aquarium2.printSize()

    println()
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()

    println()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println()
    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}