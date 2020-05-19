/**
 *  Filters are a handy way to get part of a list based on some conditions
 */

fun main() {
    eagerFilter()
    lazyFilter()
}

/**
 * Eager or lazy? is the result list created immediately?
 * or when is the list accessed?

 * In kotlin a Filter is eager,
 * each time we use filter a list is created.
 *
 * To make filters lazy use a Sequence
 * Sequence is a collection that can look at one item at a time
 * starting at the beginning and going to the end
 */

val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun eagerFilter() {
    val eager = decorations.filter { it.startsWith("p") }
    println("eager: $eager")
}

/**
 * The filtered value holds a sequence of the list items and knowledge
 * of the filter to apply to those elements.
 *
 * Whenever we access elements of the sequence the filter is applied and then the result
 * is returned.
 */
fun lazyFilter() {

    val lazyMap = decorations.asSequence()
        .map { println("access : $it"); it } // return the same thing i.e it

    /**
     * Only reference to the sequence is printed
     */
    println()
    println("lazyMap : $lazyMap")

    /**
     * Only the first element is accessed
     */
    println("-----------")
    println("first: ${lazyMap.first()}")

    /**
     * The entire list is accessed
     */
    println("-----------")
    println(lazyMap.toList())


    /**
     * The list will just be [pagoda, plastic plant]
     * Only the elements that are filtered are accessed
     */
    val lazyMap2 = decorations.asSequence().filter { it.startsWith('p') }
        .map {
            println("access : $it")
            it
        }

    println()
    println("lazyMap2 filtered : ${lazyMap2.toList()}")
}