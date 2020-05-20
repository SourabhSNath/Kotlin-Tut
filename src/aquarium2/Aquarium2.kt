package aquarium2

data class Fish(var name: String)

fun main(args: Array<String>) {
    fishExample()
    println()
    listExample()
}

fun fishExample() {
    val fish = Fish("floaty")
//    val x = with(fish.name) {
//        capitalize()
//    }
//    println(x)

    val t = myWith(fish.name) {
        println(capitalize())
        this
    }

    println("YOOO $t")

    "S".lambdaNoReturn()
    println(lambda(2))

    println()
    // Run returns the result of executing the lamdba, this just returns name
    println(fish.run { name })
    println()

    // apply returns the changed object it was applied to
    val fi = fish.apply { name = "Sourabh" }
    println(fish) // Fish has now changed to Fish(name=Sourabh)
    println(fi.name)

    // let is similar to apply but it returns a copy of the object with the changes
    // This can be useful for chaining manipulations together
    println(
        fish.name.toUpperCase()
            .let { it + "fish" }.length
            .let { it + 31 })

    println(fish.name) // Unchanged
}

val lambdaNoReturn: String.() -> Unit = { println(this) }
val lambda: (Int) -> Int = { d -> d / 2 }

/**
 * Higher order function
 *
 * Inside the function body, block is an Extension function on String object
 */
fun myWith(name: String, block: String.() -> String): String {
    return name.block()
}

fun listHigherOrderFun(list: List<Int>, operation: List<Int>.() -> List<Int>): List<Int> {
    return list.operation()
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

fun listExample() {
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    println(listHigherOrderFun(numbers) {
        numbers.filter { it % 3 == 0 }
    })

    println(numbers.divisibleBy {
        it.rem(3)
    })
}