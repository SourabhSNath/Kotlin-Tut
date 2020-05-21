/**
 * SAM acronym for Single Abstract Methods,
 * that is an interface with a single abstract method
 */

fun example() {
//    val runnable = object : Runnable {
//        override fun run() {
//            println("This is a runnable")
//        }
//    }
//    JavaRun.runNow(runnable)

    /**
     *  Instead of the above code, Kotlin let's us pass in a Lambda instead
     */
    JavaRun.runNow {
        println("Passing a lambda as a Runnable")
    }
}

fun main() {
    example()
}