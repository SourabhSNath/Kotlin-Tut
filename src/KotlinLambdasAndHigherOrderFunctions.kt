/**
 * Lambdas or lambda expressions are simply anonymous functions; a function without a name.
 * This is useful because lambda expressions can be passed as data.
 *
 * Higher-order Functions:
 * Higher-order functions are created by passing a lambda to another function.
 * Filter and map are examples of higher-order functions.
 */

fun main() {

    println("Lambda")
    lambda1()

    // Higher-order functions
    println("\nHigher-order")
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(20, waterFilter))

    // Passing a function reference instead of a lambda
    fun increaseDirty(start: Int) = start * 2
    println(updateDirty(20, ::increaseDirty))
}

fun lambda1() {
    val dirtyLevel = 20

    // Lambda
    // val waterFilter = { dirty: Int -> dirty / 2 }

    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 } // Takes in an Int and returns an Int

    println(waterFilter(dirtyLevel))
}

/**
 * Higher-order function
 */
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}