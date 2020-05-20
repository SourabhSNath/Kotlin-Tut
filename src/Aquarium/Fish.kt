package Aquarium

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

/**
 * Interface delegation
 * Instead of implementing FishColor use the implementation provided by GoldColor
 * So every time color is accessed, it is delegated to GoldColor
 */

object GoldColor : FishColor {
    override val color: String = "Gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }

}

/**
 * Usage
 */

class GoldFish :
    FishAction by PrintingFishAction("Fish Food"), FishColor by GoldColor

// Since Plecostomus is of different colors, so setting GoldColor as the default value

class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction, FishColor by fishColor {

    override fun eat() {
        println("Eat algae")
    }
}


class Shark : FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}


//class Shark : AquariumFish(), FishAction {
//    override val color = "gray"
//    override fun eat() {
//
//    }
//}
//
//class Plecostomus : AquariumFish() {
//    override val color = "gold"
//}