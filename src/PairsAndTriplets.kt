/**
 * Pairs and triplets are pre made Data Classes for two or three generic items.
 * This could be useful for having a function to return more than 1 value
 */

fun main() {

    val returnedPair = pairMethod()
    // Destructuring pairs
    val (Fishes1, Fishes2) = returnedPair

    println(Fishes1)
    println(Fishes2)
    println()

    val returnedTriplet = tripletMethod()
    val (e1, e2, e3) = returnedTriplet
    println(e1)
    println(e2)
    println(e3)
}

val isFreshWater: (String) -> Boolean = { fish ->
    when (fish) {
        "Gold Fish", "Plecostomus" -> true;
        else -> false
    }
}

/**
 * Paris,
 * function returns two things
 */
fun pairMethod(): Pair<List<String>, List<String>> {
    val stuff = Pair("1", 1)
    println(stuff.first)
    println(stuff.second)
    println()

    val listOfFish = listOf("Gold Fish", "Shark", "Plecostomus", "Star Fish")

    // Suppose we have to return this in a single function
    val twoLists = listOfFish.partition(isFreshWater) // This is a pair too

    return twoLists.first to twoLists.second //Creating a pair
}

/**
 * Triples
 * function returns three things
 */
fun tripletMethod(): Triple<List<String>, List<String>, String> {
    val listOfFish = listOf("Gold Fish", "Shark", "Plecostomus", "Star Fish")
    val twoLists = listOfFish.partition(isFreshWater)

    val tr = 1 to 2 to 3
    println(tr)

    return Triple(twoLists.first, twoLists.second, "This text")
}