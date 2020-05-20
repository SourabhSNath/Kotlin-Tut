package Aquarium.decor

data class Decoration(
    val rocks: String, val wood: String, val diver: String
)

fun makeDecoration() {
    val decoration = Decoration("granite", "wood", "diver")
    println(decoration)

//    val rock = decoration.rocks
//    val wood = decoration.wood
//    val diver = decoration.diver

    val (rock, wood, diver) = decoration
}