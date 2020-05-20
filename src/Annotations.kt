/**
 * Specifies the name for the Java class or method which is generated from this element.
 */
//@file:JvmName("InteropFish")

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

class InteropFish {

    /**
     * JvmStatic to make the interop() a static function
     * Companion object is required since the function is going to be made static
     */
    companion object {
        @JvmStatic
        fun interop() {
            // Do Something
        }
    }
}

/**
 * Creating an annotation
 */

@IAmAPlant //Using the annotation
class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing = false

    @set:OnSet
    var needsFood = false
}

/**
 * Creating a basic annotation that will be used to just say that the class is annotated
 */
annotation class IAmAPlant

// Annotation targeting getters and setters
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

/**
 * Using reflection to get information about the class at runtime
 */
//fun reflections() {
//    val classObj = Plant::class
//
//    // Print function name
//    for (function in classObj.declaredMemberFunctions) {
//        println(function.name)
//    }
//
//    // Printing all the annotation names used in the Plant class
//    for (annotation in classObj.annotations) {
//        println(annotation.annotationClass.simpleName)
//    }
//
//    // Finding an annotation and doing something with it
//    val annotated = classObj.findAnnotation<IAmAPlant>()
//    annotated?.apply {
//        println("Found the annotation and printing this")
//    }
//}